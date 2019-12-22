
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

public class Status_View_Fragment extends Fragment implements View.OnClickListener {

    private Button agent;
    TextView title;
    TextView list;
    String code;
    EditText usr;

    private LinearLayout linearlayout;

    boolean check = false, isQueue = false, isIntransit = false, isDelivered = false, isShipped = false, isDefault = false;
    Button queue, request, intransit, delivered, shipped;
    TextView tvtransit, tvshipped, tvqueue, tvdelivered;

    private ArrayList <HashMap <String, String>> listofData = new ArrayList <>();
    private ArrayList <HashMap <String, String>> listofIntransitData = new ArrayList <>();
    private ArrayList <HashMap <String, String>> listofShippedData = new ArrayList <>();
    private ArrayList <HashMap <String, String>> listofDeliveredData = new ArrayList <>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_status_view, container, false );

        //  agent = ( Button ) rootView.findViewById( R.id.btnViewAgent );
        title = ( TextView ) rootView.findViewById( R.id.tvTitle );
        list = ( TextView ) rootView.findViewById( R.id.tvReqlist );
//        usr = ( EditText ) rootView.findViewById( R.id.etTextResult );

        Button reload = ( Button ) rootView.findViewById( R.id.imreload );
        request = ( Button ) rootView.findViewById( R.id.imrequest );
        queue = ( Button ) rootView.findViewById( R.id.btnqueue );

        intransit = ( Button ) rootView.findViewById( R.id.btnintransit );
        delivered = ( Button ) rootView.findViewById( R.id.btndelivered );
        shipped = ( Button ) rootView.findViewById( R.id.btnshipped );

        tvqueue = ( TextView ) rootView.findViewById( R.id.tvqueue );
        tvshipped = ( TextView ) rootView.findViewById( R.id.tvshipped );
        tvtransit = ( TextView ) rootView.findViewById( R.id.tvtransit );
        tvdelivered = ( TextView ) rootView.findViewById( R.id.tvdelivered );

        linearlayout = ( LinearLayout ) rootView.findViewById( R.id.linearlayout );

        reload.setOnClickListener( ( View.OnClickListener ) this );
        request.setOnClickListener( ( View.OnClickListener ) this );

        queue.setOnClickListener( ( View.OnClickListener ) this );
        intransit.setOnClickListener( ( View.OnClickListener ) this );
        delivered.setOnClickListener( ( View.OnClickListener ) this );
        shipped.setOnClickListener( ( View.OnClickListener ) this );

        isDefault = true;


        getData( isDefault );


        return rootView;
    }





    private void setSizes() {


        Log.d( "Output", "ListofData textview" + Integer.toString( listofData.size() ) );

        Log.d( "Output", "ListofShipped data textview" + Integer.toString( listofShippedData.size() ) );

        tvqueue.setText( Integer.toString( listofData.size() ) );
        tvtransit.setText( Integer.toString( listofIntransitData.size() ) );
        tvshipped.setText( Integer.toString( listofShippedData.size() ) );
        tvdelivered.setText( Integer.toString( listofDeliveredData.size() ) );
    }


    private void getData(boolean check) {

        listofData.clear();
        listofShippedData.clear();
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


                            if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "QUEUEING" )) {

                                listofData.add( map );
                            } else if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "INTRANSIT" )) {

                                listofIntransitData.add( map );
                            } else if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "DELIVERED" )) {

                                listofDeliveredData.add( map );
                            } else if (map.put( "STATUS", objChild.getString( "STATUS" ) ).equalsIgnoreCase( "SHIPPED" )) {

                                listofShippedData.add( map );
                            }

                        }

                        setSizes();

                        if (isQueue || isDefault) {
                            setData( listofData );

                            Log.d( "Output", "listofData size " + listofData.size() );

                        }

                        if (isIntransit) {
                            setTransit( listofIntransitData );
                            Log.d( "Output", "listofIntransitData size " + listofIntransitData.size() );
                        }

                        if (isDelivered) {
                            setDelivered( listofDeliveredData );
                            Log.d( "Output", "listofDeliveredData size " + listofDeliveredData.size() );
                        }

                        if (isShipped) {
                            setShipped( listofShippedData );
                            Log.d( "Output", "listofShipped data size " + listofShippedData.size() );
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
                    tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" ) );

                    tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvStatus.setText( map.get( "STATUS" ) );


                    linearlayout.addView( view );
                    progressBar.hide();


                }
            }
        }
        isQueue = false;
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

                View view = inflater.inflate( R.layout.status_rows, linearlayout, false );

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
                    tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" ) );

                    tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvStatus.setText( map.get( "STATUS" ) );


                    linearlayout.addView( view );
                }
            }

        }
        isIntransit = false;
    }


    private void setDelivered(final ArrayList <HashMap <String, String>> listofDeliveredData) {


        linearlayout.removeAllViews();
        progressBar.show();


        if (listofDeliveredData.size() == 0) {

            linearlayout.removeAllViews();
            progressBar.hide();

            //  customDialog( "No record", "No Package Delivered", "", "okMethod" );
        } else {
            LayoutInflater inflater = LayoutInflater.from( getActivity() );

            for (int i = 0; i < listofDeliveredData.size(); i++) {

                View view = inflater.inflate( R.layout.status_rows, linearlayout, false );

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
                    tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" ) );

                    tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvStatus.setText( map.get( "STATUS" ) );


                    linearlayout.addView( view );
                    progressBar.hide();


                }
            }
        }
        isDelivered = false;
    }


    private void setShipped(final ArrayList <HashMap <String, String>> listofShippedData) {


        linearlayout.removeAllViews();
        progressBar.show();


        if (listofShippedData.size() == 0) {
            linearlayout.removeAllViews();
            progressBar.hide();

            //    customDialog( "Not found", "No package Shipped", "", "okMethod" );

        } else {
            LayoutInflater inflater = LayoutInflater.from( getActivity() );

            for (int i = 0; i < listofShippedData.size(); i++) {

                View view = inflater.inflate( R.layout.status_rows, linearlayout, false );

                TextView tvDate = ( TextView ) view.findViewById( R.id.date );
                TextView tvId = ( TextView ) view.findViewById( R.id.id );
                TextView tvItem = ( TextView ) view.findViewById( R.id.item );
                TextView tvQuantity = ( TextView ) view.findViewById( R.id.quantity );

                TextView tvCost = ( TextView ) view.findViewById( R.id.cost );
                TextView tvRemarks = ( TextView ) view.findViewById( R.id.remarks );
                TextView tvToken = ( TextView ) view.findViewById( R.id.token );
                TextView tvStatus = ( TextView ) view.findViewById( R.id.status );
                Button track = ( Button ) view.findViewById( R.id.track );


                HashMap <String, String> map = listofShippedData.get( i );

                if (map.get( "STATUS" ).equalsIgnoreCase( "SHIPPED" )) {
                    tvDate.setText( map.get( "DATE" ).substring( 0, 10 ) );
                    tvId.setText( map.get( "ID" ) );
                    tvItem.setText( map.get( "ITEM" ) );

                    tvQuantity.setText( map.get( "QUANTITY" ) );
                    tvCost.setText( map.get( "COST" ) );
                    tvRemarks.setText( map.get( "REMARKS" ) );
                    tvToken.setText( map.get( "PAYMENT_CODE" ) );
                    tvStatus.setText( map.get( "STATUS" ) );


                    linearlayout.addView( view );
                    progressBar.hide();


                }
            }
        }
        isShipped = false;
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

        linearlayout.removeAllViews();
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

















