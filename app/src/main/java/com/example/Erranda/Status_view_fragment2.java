
//Displays all Customer Transaction and provides addtional Query Options

package com.example.Erranda;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.android.volley.VolleyLog.TAG;

public class Status_view_fragment2 extends Fragment implements View.OnClickListener {

    private Button agent;
    TextView title;
    TextView list, title_status;
    String code;
    EditText usr;

    private LinearLayout linearlayout;

    boolean check = false, isQueue = false, isIntransit = false, isDelivered = false, isShipped = false, isDefault = false;
    Button queue, request, intransit, delivered, shipped;
    TextView tvtransit, tvshipped, tvqueue, tvdelivered;

    private ArrayList <HashMap <String, String>> listofData = new ArrayList <>();
    private ArrayList <HashMap <String, String>> listofIntransitData = new ArrayList <>();
    private ArrayList <HashMap <String, String>> listofOnholdData = new ArrayList <>();
    private ArrayList <HashMap <String, String>> listofDeliveredData = new ArrayList <>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.status_view2, container, false );

        title_status = ( TextView ) rootView.findViewById( R.id.title_status );

        linearlayout = ( LinearLayout ) rootView.findViewById( R.id.linearlayout );


        if(Constant.isQueue){
            title_status.setText("Request In Queue");
        }

        else if(Constant.isIntransit){
            title_status.setText("Package In Transit");
        }

        else if(Constant.isDelivered){
            title_status.setText("Package Delivered");
        }

        else if(Constant.isOnhold){
            title_status.setText("Package Onhold");
        }

        isDefault = true;
        getData( isDefault );
        return rootView;
    }



    private void getData(boolean check) {

        listofData.clear();
        listofOnholdData.clear();
        listofDeliveredData.clear();
        listofIntransitData.clear();

        linearlayout.removeAllViews();

        String url = Constant.url + "cust_request?username=" + Constant.username;

        RequestQueue queue = Volley.newRequestQueue( getActivity() );
        queue.start();

        Log.d( "Output", "status url " + Constant.url );

        //API CALL

        StringRequest sr = new StringRequest( Request.Method.GET, url, new Response.Listener <String>() {
            @Override
            public void onResponse(String response) {

                Log.d( "Output", "API Response " + response );
                try {

                    JSONArray objArray = new JSONArray( response );
                    Log.d( "Ouput", "API response " + response );

                    if (objArray.length() == 0) {
                        customDialog( "Message", "No record found", "", "okMethod" );
                    } else {

                        for (int k = 0; k < objArray.length(); k++) {

                            JSONObject objChild = objArray.getJSONObject( k );
                            HashMap <String, String> map = new HashMap <>();
                            map.put( "DATE", objChild.getString( "DATE" ) );
                            map.put( "ID", objChild.getString( "ID" ) );
                            map.put( "ITEM", objChild.getString( "ITEM" ) );
                            map.put( "QUANTITY", objChild.getString( "QUANTITY" ) );
                            map.put( "COST", objChild.getString( "COST" ) );
                            map.put( "REMARKS", objChild.getString( "REMARKS" ) );
                            map.put( "TOWN", objChild.getString( "TOWN" ) );
                            map.put( "RESIDENCE", objChild.getString( "RESIDENCE" ) );
                            map.put( "CONTACT", objChild.getString( "CONTACT" ) );
                            map.put( "DIGITAL_ADDRESS", objChild.getString( "DIGITAL_ADDRESS" ) );

                            map.put( "TOWN_d", objChild.getString( "TOWN_d" ) );
                            map.put( "RESIDENCE_d", objChild.getString( "RESIDENCE_d" ) );
                            map.put( "CONTACT_d", objChild.getString( "CONTACT_d" ) );
                            map.put( "DIGITAL_ADDRESS_d", objChild.getString( "DIGITAL_ADDRESS_d" ) );
                            map.put( "PAYMENT_CODE", objChild.getString( "PAYMENT_CODE" ) );
                            map.put( "STATUS", objChild.getString( "STATUS" ) );
                            map.put( "BUSINESS_NAME", objChild.getString( "BUSINESS_NAME" ) );


                            if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "QUEUEING" )) {

                                listofData.add( map );
                            } else if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "INTRANSIT" )) {

                                listofIntransitData.add( map );
                            } else if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "DELIVERED" )) {

                                listofDeliveredData.add( map );
                            } else if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "ONHOLD" )) {

                                listofOnholdData.add( map );
                            }

                        }


                        if(Constant.isQueue){
                       // if (isQueue || isDefault) {
                            setData( listofData );

                            Log.d( "Output", "listofData size " + listofData.size() );

                        }

                        if (Constant.isIntransit) {
                            setTransit( listofIntransitData );
                            Log.d( "Output", "listofIntransitData size " + listofIntransitData.size() );
                        }

                        if (Constant.isDelivered) {
                            setDelivered( listofDeliveredData );
                            Log.d( "Output", "listofDeliveredData size " + listofDeliveredData.size() );
                        }

                        if (Constant.isOnhold) {
                            setOnhold( listofOnholdData );
                            Log.d( "Output", "listofShipped data size " + listofOnholdData.size() );
                        }


                    }


                    //  progressBar.hide();


                } catch (Exception ex) {
                    ex.printStackTrace();
                    // displ( response );
                    //Utils.showToast(getActivity(), response);
                }


            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d( "Output", "Error" + error );

                progressBar.hide();
                if (error.toString().contains( "failed to connect to " + url )) {
                    // customDialog( "Error", "Connection error...", "", "okMethod" );
                    //unsuccessful = true;
                }

            }
        } ) {


            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add( sr );

    }


    private void setData(final ArrayList <HashMap <String, String>> listofData) {

        Log.d( "Output", "Set Data Called " );

        linearlayout.removeAllViews();
        progressBar.show();

        Log.d( "Output", " Exported Data: " + listofData );
        Log.d( "Output", " Exported Data Size: " + listofData.size() );

        if (listofData.size() == 0) {
            linearlayout.removeAllViews();
            progressBar.hide();

            //  customDialog( "No record", "No request in Queue","", "okMethod" );
        } else {
            LayoutInflater inflater = LayoutInflater.from( getActivity() );

            for (int i = 0; i < listofData.size(); i++) {


                View view = inflater.inflate( R.layout.cardview, linearlayout, false );


                TextView tvpartner = (TextView ) view.findViewById( R.id.tvpartner );
                TextView tvpicktown = (TextView ) view.findViewById( R.id.picklocation );
//                TextView tvpickcontact = (TextView ) view.findViewById( R.id.pickcontact );

                TextView tvdispatchtown = (TextView ) view.findViewById( R.id.dispatchlocation );
//                TextView tvdispatchcontact = (TextView ) view.findViewById( R.id.dispatchcontact );


                TextView tvserail = (TextView) view.findViewById( R.id.tvserial );
                TextView tvDate = ( TextView ) view.findViewById( R.id.date );
                TextView tvId = ( TextView ) view.findViewById( R.id.id );
                TextView tvItem = ( TextView ) view.findViewById( R.id.item );
                TextView tvQuantity = ( TextView ) view.findViewById( R.id.quantity );

                TextView tvCost = ( TextView ) view.findViewById( R.id.cost );
                TextView tvRemarks = ( TextView ) view.findViewById( R.id.remarks );
                TextView tvToken = ( TextView ) view.findViewById( R.id.token );
                TextView tvStatus = ( TextView ) view.findViewById( R.id.status );
                Button track = ( Button ) view.findViewById( R.id.track );


                HashMap <String, String> map = listofData.get( i );

                if (map.get( "STATUS" ).equalsIgnoreCase( "QUEUEING" )) {
                    tvDate.setText( map.get( "DATE" ).substring( 0, 10 ) );

                  tvpicktown.setText(map.get("TOWN")+ ", "+ map.get("RESIDENCE")+", Contact: "+map.get("CONTACT")+ " GPS: "+map.get("DIGITAL_ADDRESS"));
               //   tvpickcontact.setText(map.get("CONTACT"));

                    tvdispatchtown.setText(map.get("TOWN_d")+ ", "+ map.get("RESIDENCE_d")+", Contact: "+map.get("CONTACT_d")+ " GPS: "+map.get("DIGITAL_ADDRESS_d"));
                   // tvdispatchcontact.setText(map.get("CONTACT_d"));


                   // tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" )+ ", Qty: "+map.get("QUANTITY") );

                  //  tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvserail.setText("Serial No: 000000"+map.get("ID"));
                    tvpartner.setText(map.get("BUSINESS_NAME"));


                    linearlayout.addView( view );
                    progressBar.hide();


                }
            }
        }
        Constant.isQueue = false;
    }


    private void setTransit(final ArrayList <HashMap <String, String>> listofIntransitData) {


        linearlayout.removeAllViews();
        progressBar.show();

        if (listofIntransitData.size() == 0) {

            linearlayout.removeAllViews();
            progressBar.hide();

            //  customDialog( "No record", "No  package in Transit","", "okMethod" );
        } else {

            LayoutInflater inflater = LayoutInflater.from( getActivity() );

            for (int i = 0; i < listofIntransitData.size(); i++) {

                View view = inflater.inflate( R.layout.cardview, linearlayout, false );

                TextView tvpartner = (TextView ) view.findViewById( R.id.tvpartner );
                TextView tvpicktown = (TextView ) view.findViewById( R.id.picklocation );
//                TextView tvpickcontact = (TextView ) view.findViewById( R.id.pickcontact );

                TextView tvdispatchtown = (TextView ) view.findViewById( R.id.dispatchlocation );
//                TextView tvdispatchcontact = (TextView ) view.findViewById( R.id.dispatchcontact );


                TextView tvserail = (TextView) view.findViewById( R.id.tvserial );
                TextView tvDate = ( TextView ) view.findViewById( R.id.date );
                TextView tvId = ( TextView ) view.findViewById( R.id.id );
                TextView tvItem = ( TextView ) view.findViewById( R.id.item );
                TextView tvQuantity = ( TextView ) view.findViewById( R.id.quantity );

                TextView tvCost = ( TextView ) view.findViewById( R.id.cost );
                TextView tvRemarks = ( TextView ) view.findViewById( R.id.remarks );
                TextView tvToken = ( TextView ) view.findViewById( R.id.token );
                TextView tvStatus = ( TextView ) view.findViewById( R.id.status );
                Button track = ( Button ) view.findViewById( R.id.track );

                HashMap <String, String> map = listofIntransitData.get( i );

                if (map.get( "STATUS" ).equalsIgnoreCase( "INTRANSIT" )) {
                    tvDate.setText( map.get( "DATE" ).substring( 0, 10 ) );

                    tvpicktown.setText(map.get("TOWN")+ ", "+ map.get("RESIDENCE")+", Contact: "+map.get("CONTACT")+ " GPS: "+map.get("DIGITAL_ADDRESS"));
                    //   tvpickcontact.setText(map.get("CONTACT"));

                    tvdispatchtown.setText(map.get("TOWN_d")+ ", "+ map.get("RESIDENCE_d")+", Contact: "+map.get("CONTACT_d")+ " GPS: "+map.get("DIGITAL_ADDRESS_d"));
                    // tvdispatchcontact.setText(map.get("CONTACT_d"));


                    // tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" )+ ", Qty: "+map.get("QUANTITY") );

                    //  tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvserail.setText("Serial No: 000000"+map.get("ID"));
                    tvpartner.setText(map.get("BUSINESS_NAME"));


                    linearlayout.addView( view );
                }
            }

        }
        Constant.isIntransit = false;
    }


    private void setDelivered(final ArrayList <HashMap <String, String>> listofDeliveredData) {


        linearlayout.removeAllViews();
        progressBar.show();


        if (listofDeliveredData.size() == 0) {

            linearlayout.removeAllViews();
            progressBar.hide();

             customDialog( "Message", "No Package Delivered", "", "okMethod" );
        } else {
            LayoutInflater inflater = LayoutInflater.from( getActivity() );

            for (int i = 0; i < listofDeliveredData.size(); i++) {

                View view = inflater.inflate( R.layout.cardview, linearlayout, false );

                TextView tvpartner = (TextView ) view.findViewById( R.id.tvpartner );
                TextView tvpicktown = (TextView ) view.findViewById( R.id.picklocation );
//                TextView tvpickcontact = (TextView ) view.findViewById( R.id.pickcontact );

                TextView tvdispatchtown = (TextView ) view.findViewById( R.id.dispatchlocation );
//                TextView tvdispatchcontact = (TextView ) view.findViewById( R.id.dispatchcontact );


                TextView tvserail = (TextView) view.findViewById( R.id.tvserial );
                TextView tvDate = ( TextView ) view.findViewById( R.id.date );
                TextView tvId = ( TextView ) view.findViewById( R.id.id );
                TextView tvItem = ( TextView ) view.findViewById( R.id.item );
                TextView tvQuantity = ( TextView ) view.findViewById( R.id.quantity );

                TextView tvCost = ( TextView ) view.findViewById( R.id.cost );
                TextView tvRemarks = ( TextView ) view.findViewById( R.id.remarks );
                TextView tvToken = ( TextView ) view.findViewById( R.id.token );
                TextView tvStatus = ( TextView ) view.findViewById( R.id.status );
                Button track = ( Button ) view.findViewById( R.id.track );


                HashMap <String, String> map = listofDeliveredData.get( i );

                if (map.get( "STATUS" ).equalsIgnoreCase( "DELIVERED" )) {
                    tvDate.setText( map.get( "DATE" ).substring( 0, 10 ) );

                    tvpicktown.setText(map.get("TOWN")+ ", "+ map.get("RESIDENCE")+", Contact: "+map.get("CONTACT")+ " GPS: "+map.get("DIGITAL_ADDRESS"));
                    //   tvpickcontact.setText(map.get("CONTACT"));

                    tvdispatchtown.setText(map.get("TOWN_d")+ ", "+ map.get("RESIDENCE_d")+", Contact: "+map.get("CONTACT_d")+ " GPS: "+map.get("DIGITAL_ADDRESS_d"));
                    // tvdispatchcontact.setText(map.get("CONTACT_d"));


                    // tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" )+ ", Qty: "+map.get("QUANTITY") );

                    //  tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvserail.setText("Serial No: 000000"+map.get("ID"));
                    tvpartner.setText(map.get("BUSINESS_NAME"));


                    linearlayout.addView( view );
                    progressBar.hide();


                }
            }
        }
        Constant.isDelivered = false;
    }


    private void setOnhold(final ArrayList <HashMap <String, String>> listofOnholdData) {


        linearlayout.removeAllViews();
        progressBar.show();


        if (listofOnholdData.size() == 0) {
            linearlayout.removeAllViews();
            progressBar.hide();

                customDialog( "Message", "No package Onhold", "", "okMethod" );

        } else {
            LayoutInflater inflater = LayoutInflater.from( getActivity() );

            for (int i = 0; i < listofOnholdData.size(); i++) {

                View view = inflater.inflate( R.layout.cardview, linearlayout, false );


                TextView tvpartner = (TextView ) view.findViewById( R.id.tvpartner );
                TextView tvpicktown = (TextView ) view.findViewById( R.id.picklocation );
//                TextView tvpickcontact = (TextView ) view.findViewById( R.id.pickcontact );

                TextView tvdispatchtown = (TextView ) view.findViewById( R.id.dispatchlocation );
//                TextView tvdispatchcontact = (TextView ) view.findViewById( R.id.dispatchcontact );


                TextView tvserail = (TextView) view.findViewById( R.id.tvserial );
                TextView tvDate = ( TextView ) view.findViewById( R.id.date );
                TextView tvId = ( TextView ) view.findViewById( R.id.id );
                TextView tvItem = ( TextView ) view.findViewById( R.id.item );
                TextView tvQuantity = ( TextView ) view.findViewById( R.id.quantity );

                TextView tvCost = ( TextView ) view.findViewById( R.id.cost );
                TextView tvRemarks = ( TextView ) view.findViewById( R.id.remarks );
                TextView tvToken = ( TextView ) view.findViewById( R.id.token );
                TextView tvStatus = ( TextView ) view.findViewById( R.id.status );
                Button track = ( Button ) view.findViewById( R.id.track );


                HashMap <String, String> map = listofOnholdData.get( i );

                if (map.get( "STATUS" ).equalsIgnoreCase( "ONHOLD" )) {
                    tvDate.setText( map.get( "DATE" ).substring( 0, 10 ) );

                    tvpicktown.setText(map.get("TOWN")+ ", "+ map.get("RESIDENCE")+", Contact: "+map.get("CONTACT")+ " GPS: "+map.get("DIGITAL_ADDRESS"));
                    //   tvpickcontact.setText(map.get("CONTACT"));

                    tvdispatchtown.setText(map.get("TOWN_d")+ ", "+ map.get("RESIDENCE_d")+", Contact: "+map.get("CONTACT_d")+ " GPS: "+map.get("DIGITAL_ADDRESS_d"));
                    // tvdispatchcontact.setText(map.get("CONTACT_d"));


                    // tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" )+ ", Qty: "+map.get("QUANTITY") );

                    //  tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvserail.setText("Serial No: 000000"+map.get("ID"));
                    tvpartner.setText(map.get("BUSINESS_NAME"));


                    linearlayout.addView( view );
                    progressBar.hide();


                }
            }
        }
        Constant.isOnhold = false;
    }


    public void onPressed(Button button, int drawable) {

        button.setBackgroundResource( drawable );

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imreload:
                if (queue.isSelected()) {
                    isQueue = true;
                    getData( isQueue );
                }
                if (intransit.isSelected()) {
                    isIntransit = true;
                    getData( isIntransit );
                }
                if (delivered.isSelected()) {
                    isDelivered = true;
                    getData( isDelivered );
                }
                if (shipped.isSelected()) {
                    isShipped = true;
                    getData( isShipped );
                }


                break;

            case R.id.imrequest:

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.addToBackStack( null );
                fr.replace( R.id.fragment_container, new Package_Detail_Fragment() );
                fr.commit();

                break;


            case R.id.btnqueue:
                isQueue = true;

                getData( isQueue );

                onPressed( queue, R.drawable.buttonstyleslectormystyle );
                intransit.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                delivered.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                shipped.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );

                break;

            case R.id.btnintransit:
                isIntransit = true;


                onPressed( intransit, R.drawable.buttonstyleslectormystyle );
                queue.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                delivered.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                shipped.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );

                getData( isIntransit );

                break;

            case R.id.btndelivered:
                isDelivered = true;

                //  delivered.setBackgroundColor( Color.MAGENTA);

                onPressed( delivered, R.drawable.buttonstyleslectormystyle );
                queue.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                intransit.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                shipped.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );

                getData( isDelivered );

                break;

            case R.id.btnshipped:
                isShipped = true;

                //   shipped.setBackgroundColor( Color.MAGENTA);
                onPressed( shipped, R.drawable.buttonstyleslectormystyle );

                queue.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                intransit.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );
                delivered.setBackgroundResource( R.drawable.buttonstyleselectormyselectornobackground );

                getData( isDelivered );

        }

    }


    private void okMethod() {

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.addToBackStack( null );
        fr.replace( R.id.fragment_container, new TaskList_Fragment() );
        fr.commit();

      //  linearlayout.removeAllViews();
        progressBar.hide();

    }


    public void customDialog(String title, String message, final String cancelMethod, final String okMethod) {
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder( getContext() );

        //  builderSingle.setIcon( R.drawable.momo2 );
        builderSingle.setTitle( title );
        builderSingle.setMessage( message );

        builderSingle.setTitle( title );
        builderSingle.setMessage( message );
        builderSingle.setCancelable( false );

        builderSingle.setPositiveButton(

                "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Log.d( TAG, "onClick: Enter Code Called." );
                        if (okMethod.equals( "okMethod" )) {
                            okMethod();
                        }

                    }
                } );
        builderSingle.show();

    }

    private void toastMessage(String message) {
        Toast.makeText( getContext(), message, Toast.LENGTH_SHORT ).show();
    }





}

















