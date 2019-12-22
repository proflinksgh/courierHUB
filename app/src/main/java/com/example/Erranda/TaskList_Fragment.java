
// Display's Transaction Request and Status for Clients


package com.example.Erranda;

import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static com.android.volley.VolleyLog.TAG;

public class TaskList_Fragment extends Fragment implements View.OnClickListener {

    private List<HashMap <String, String>> listofData = new ArrayList<>();
    private List<HashMap <String, String>> listofShippedData = new ArrayList<>();
    private List<HashMap <String, String>> listofIntransitData = new ArrayList<>();
    private List<HashMap <String, String>> listofDeliveredData = new ArrayList<>();


    TextView tvqueue, tvshipped, tvintransit, tvdelivered;
    Button btnqueue, btnintransit, btndelivered, btnonhold, btngetsupport;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_tasklist, container, false );

        btngetsupport = (Button) rootView.findViewById( R.id.btngetsupport );
        btnqueue = (Button) rootView.findViewById( R.id.btnqueue );
        btnintransit = (Button) rootView.findViewById( R.id.btnintransit );
        btndelivered = (Button) rootView.findViewById( R.id.btndelivered );
        btnonhold = (Button) rootView.findViewById( R.id.btnonhold );

        tvqueue = (TextView ) rootView.findViewById( R.id.tvqueue );
       // tvshipped = (TextView ) rootView.findViewById( R.id.tvshipped );
        tvintransit = (TextView ) rootView.findViewById( R.id.tvintransit );
        tvdelivered = (TextView ) rootView.findViewById( R.id.tvdelivered );


        Button btnrequest = ( Button ) rootView.findViewById( R.id.btnRequest );
        btngetsupport = (Button) rootView.findViewById( R.id.btngetsupport );
//        Button button4 = ( Button ) rootView.findViewById( R.id.btnCheck );
//        Button btnhelp = (Button) rootView.findViewById( R.id.btnhelp );
//        Button gallary = (Button) rootView.findViewById( R.id.btngallary );
//        Button partners = (Button) rootView.findViewById( R.id.partners );

        btnrequest.setOnClickListener( ( View.OnClickListener ) this );
        btnqueue.setOnClickListener( ( View.OnClickListener ) this );

        btnintransit.setOnClickListener( ( View.OnClickListener ) this );
        btndelivered.setOnClickListener( ( View.OnClickListener ) this );
        btnonhold.setOnClickListener( ( View.OnClickListener ) this );
        btngetsupport.setOnClickListener( ( View.OnClickListener ) this );


//        btnhelp.setOnClickListener( (View.OnClickListener)this );
//        button4.setOnClickListener( ( View.OnClickListener ) this );
//        gallary.setOnClickListener( ( View.OnClickListener ) this );
//        partners.setOnClickListener( ( View.OnClickListener ) this );


        Log.d("Output","Latitude is "+ Constant.latitude);
        Log.d("Output","Longitude is "+ Constant.longitude);


            getAddress();
            getData();


    clearBackStack();

        return rootView;
    }

    private void clearBackStack() {
        FragmentManager manager = getFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }


    @Override

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnRequest:   //Request Button. Instantiates/Calls Package_Detail_Fragment Fragment when Clicked

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.addToBackStack( null );
                fr.replace( R.id.fragment_container, new Package_Detail_Fragment() );
                fr.commit();
                break;


            case R.id.btnqueue:   //Request Button. Instantiates/Calls Package_Detail_Fragment Fragment when Clicked

                Log.d("Output", "Queue clicked");
                Constant.isQueue = true;

                FragmentTransaction frqueue = getFragmentManager().beginTransaction();
                frqueue.addToBackStack( null );
                frqueue.replace( R.id.fragment_container, new Status_view_fragment2());
                frqueue.commit();
                break;


            case R.id.btnintransit:   //Request Button. Instantiates/Calls Package_Detail_Fragment Fragment when Clicked

                Log.d("Output", "Queue clicked");
                Constant.isIntransit = true;

                FragmentTransaction transit = getFragmentManager().beginTransaction();
                transit.addToBackStack( null );
                transit.replace( R.id.fragment_container, new Status_view_fragment2());
                transit.commit();
                break;


            case R.id.btndelivered:   //Request Button. Instantiates/Calls Package_Detail_Fragment Fragment when Clicked

                Log.d("Output", "Queue clicked");
                Constant.isDelivered = true;

                FragmentTransaction delivered = getFragmentManager().beginTransaction();
                delivered.addToBackStack( null );
                delivered.replace( R.id.fragment_container, new Status_view_fragment2());
                delivered.commit();
                break;


            case R.id.btnonhold:   //Request Button. Instantiates/Calls Package_Detail_Fragment Fragment when Clicked

                Log.d("Output", "Queue clicked");
                Constant.isOnhold = true;

                FragmentTransaction onhold = getFragmentManager().beginTransaction();
                onhold.addToBackStack( null );
                onhold.replace( R.id.fragment_container, new Status_view_fragment2());
                onhold.commit();
                break;


            case R.id.btngetsupport:

                FragmentTransaction support = getFragmentManager().beginTransaction();
                support.addToBackStack( null );
                support.replace( R.id.fragment_container, new fragement_getSupport());
                support.commit();

                break;



//
//
//            case R.id.partners:
//
//                Constant.isCheckPass = true;
//
//                FragmentTransaction trans = getFragmentManager().beginTransaction();
//                trans.addToBackStack( null );
//                trans.replace( R.id.fragment_container, new Partner_view() );
//                trans.commit();
//
//                break;
//
//
//
//            case R.id.btnCheck:   //Status Button. Instantiates getView
//
//
//                progressBar.show();
//                FragmentTransaction frg = getFragmentManager().beginTransaction();
//                frg.addToBackStack( null );
//                frg.replace( R.id.fragment_container, new Status_View_Fragment() );  //Instantiates fragment_status_view Fragment after if Retrieval is Successfuls
//                frg.commit();
//
//                progressBar.hide();
//
//                break;
//
//            case R.id.btnhelp:
//
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.addToBackStack( null );
//                fragmentTransaction.replace( R.id.fragment_container, new fragement_getSupport() );  //Instantiates fragment_status_view Fragment after if Retrieval is Successfuls
//                fragmentTransaction.commit();
//
//                break;
//
//            case R.id.btngallary:
//
//                FragmentTransaction frtrans = getFragmentManager().beginTransaction();
//                frtrans.addToBackStack( null );
//                frtrans.replace( R.id.fragment_container, new Gallary_main() );  //Instantiates fragment_status_view Fragment after if Retrieval is Successfuls
//                frtrans.commit();
//
//                break;


        }
    }




    private void getData() {

        listofData.clear();
        listofShippedData.clear();
        listofDeliveredData.clear();
        listofIntransitData.clear();

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


                        for (int k = 0; k < objArray.length(); k++) {

                            JSONObject objChild = objArray.getJSONObject( k );
                            HashMap <String, String> map = new HashMap <>();

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

                        setSize();


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





private void setSize(){


    tvqueue.setText( Integer.toString( listofData.size() ) );
    tvintransit.setText( Integer.toString( listofIntransitData.size() ) );
   // tvshipped.setText( Integer.toString( listofShippedData.size() ) );
    tvdelivered.setText( Integer.toString( listofDeliveredData.size() ) );
}



    public void getAddress() {
        Geocoder geocoder = new Geocoder( getActivity(), Locale.getDefault() );
        try {
            List <Address> addresses = geocoder.getFromLocation( Constant.latitude, Constant.longitude, 1 );

            Log.d("Output", "Address is "+ addresses.toString());




          //  String usern = Constant.userName.split("\\=")[0];


//            Address obj = addresses.get( 0 );
//            String add = obj.getAddressLine( 0 );
//            add = add + "\n" + obj.getCountryName();
//            add = add + "\n" + obj.getCountryCode();
//            add = add + "\n" + obj.getAdminArea();
//            add = add + "\n" + obj.getPostalCode();
//            add = add + "\n" + obj.getSubAdminArea();
//            add = add + "\n" + obj.getLocality();
//            add = add + "\n" + obj.getSubThoroughfare();
//




                Constant.mylocation = addresses.toString();




         // Constant.mylocation = dataParsed.substring( 13 );








        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText( getActivity(), e.getMessage(), Toast.LENGTH_SHORT ).show();

        }

    }




    private void okMethod(){
            Log.d(TAG, "okMethod: Called");
        }

        public void customDialog(String title, String message, final String cancelMethod, final String okMethod ){
            final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder(getContext());

            builderSingle.setTitle( title );
            builderSingle.setMessage(message);


            builderSingle.setPositiveButton(

                    "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                            Log.d(TAG, "onClick: Enter Code Called.");
                            if(okMethod.equals("okMethod")){
                                okMethod();
                            }
                        }
                    } );
            builderSingle.show();
        }

        private void toastMessage(String message) {
            Toast.makeText( getActivity(), message, Toast.LENGTH_SHORT ).show();
        }





    }













