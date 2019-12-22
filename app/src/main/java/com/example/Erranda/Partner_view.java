package com.example.Erranda;


import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
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
import java.util.List;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.android.volley.VolleyLog.TAG;


public class Partner_view extends Fragment implements View.OnClickListener {

    WebView webView;

    LinearLayout layout1, layout2, layoutwebview, headlayout;
    TextView tvheading;
    Button btncontinue, btnerrandaprofile, btnsmartcity, btnsmartcityprofile, btnerranda, btnabiquick, btnabiquickprofile,
    btnsmriders, btnsmridersprofile;

    String partnerId = "";

    private List<HashMap <String, String>> listofData = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_partner, container, false );



         btnsmartcityprofile = ( Button ) rootView.findViewById( R.id.btnsmartcityprofile );
         btnerrandaprofile = (Button) rootView.findViewById( R.id.btnerrandaghprofile );
         btnabiquickprofile = ( Button )rootView.findViewById( R.id.btnabiquickprofile );
         btnsmridersprofile = (Button)rootView.findViewById( R.id.btnsmridersprofile );
         btncontinue = (Button)rootView.findViewById( R.id.btncontinue );
         webView = (WebView )rootView.findViewById( R.id.webshow );
         layoutwebview = (LinearLayout ) rootView.findViewById( R.id.layoutwebview );
         layout1 = (LinearLayout ) rootView.findViewById( R.id.layout1 );
         layout2 = (LinearLayout ) rootView.findViewById( R.id.layout2 );
        headlayout = (LinearLayout ) rootView.findViewById( R.id.headlayout );

         btnsmartcityprofile.setOnClickListener( (View.OnClickListener)this );
         btnerrandaprofile.setOnClickListener( ( View.OnClickListener ) this );
         btnabiquickprofile.setOnClickListener( (View.OnClickListener)this );
         btnsmridersprofile.setOnClickListener( ( View.OnClickListener ) this );
         btncontinue.setOnClickListener( (View.OnClickListener)this );



         Log.d("Output", "isPartnersfromTasklist " + Constant.isCheckPass);


         if(Constant.isCheckPass){
             headlayout.setVisibility( View.GONE );
             btncontinue.setVisibility( View.GONE );
         }


         else{
             headlayout.setVisibility( View.VISIBLE );
             btncontinue.setVisibility( View.VISIBLE );
         }


         Constant.isCheckPass = false;



        RadioGroup radioGroup = ( RadioGroup ) rootView.findViewById( R.id.radiogroup1 );
        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId) {
                case R.id.rbsmartcity:

                    Constant.selectedPartner = "Smart City";




                    break;
            }
        }
    } );




        RadioGroup radiongroup2 = ( RadioGroup ) rootView.findViewById( R.id.rbgroup2 );
        radiongroup2.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rberranda:

                        Constant.selectedPartner = "Erranda Delivery Service";

                        Log.d("Output", "Erranda is clicked "+Constant.selectedPartner);

                        break;
                }
            }
        } );




        RadioGroup radiongroup3 = ( RadioGroup ) rootView.findViewById( R.id.radiogroup3 );
        radiongroup3.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rbabiquick:

                        Constant.selectedPartner = "Abi Quick";

                        break;
                }
            }
        } );



        RadioGroup radiongroup4 = ( RadioGroup ) rootView.findViewById( R.id.rbgroup4 );
        radiongroup4.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rbsmriders:

                        Constant.selectedPartner = "SMRiders";

                        break;
                }
            }
        } );







        return rootView;
    }



    //Generate Random Number for Cost

    private void costCalc(){

        Random r = new Random();
        int low = 25;
        int high = 30;
        int result = r.nextInt(high-low) + low;
        Constant.cost = Integer.toString(result);
    }




    //Get all partners to retrieve Partner Id

    public void  getPartners(){

        //Call API

        String url = Constant.url + "partners" ;



        RequestQueue queue = Volley.newRequestQueue( getActivity());
        queue.start();

        progressBar progressBar = new progressBar( getActivity() );
        progressBar.show();

        StringRequest sr = new StringRequest( Request.Method.GET, url, new Response.Listener <String>() {



            @Override
            public void onResponse(String response) {


                try {

                    JSONArray objArray = new JSONArray( response );
                    Log.d( "Ouput", "API response " + response );


                    for (int k = 0; k < objArray.length(); k++) {

                        JSONObject objChild = objArray.getJSONObject( k );
                        HashMap <String, String> map = new HashMap <>();
                        map.put( "BUSINESS_NAME", objChild.getString( "BUSINESS_NAME" ) );
                        map.put( "PARTNER_ID", objChild.getString( "PARTNER_ID" ) );
//                        map.put( "REG_NO", objChild.getString( "REG_NO" ) );
//                        map.put( "CONTACT", objChild.getString( "CONTACT" ) );
//
//                        map.put( "CONTACT1", objChild.getString( "CONTACT1" ) );
//                        map.put( "CONTACT2", objChild.getString( "CONTACT2" ) );
//                        map.put( "LOCATION", objChild.getString( "LOCATION" ) );
//                        map.put( "GPS_ADDRESS", objChild.getString( "GPS_ADDRESS" ) );


                        listofData.add(map);



                        if (map.put( "BUSINESS_NAME", objChild.getString( "BUSINESS_NAME" ) ).equalsIgnoreCase( Constant.selectedPartner ) ) {
                        progressBar.hide();

                        Constant.partnerId = map.get("PARTNER_ID");


                            }

                    }

                    Log.d("Output", "Partner Info" + Constant.partnerId);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Output", "Error"+ error);

                progressBar.hide();
//                if(error.toString().contains( "failed to connect")){
//                    customDialog( "Connection Error", "Check your Internet and try again", "", "okMethod" );
//                    //unsuccessful = true;
//                }

            }
        } ) {


            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add( sr );

    }




    @Override

    public void onClick(View v) {

        switch (v.getId()) {



            case R.id.btncontinue:



                costCalc();
                getPartners();



                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.addToBackStack( null );
                fr.replace( R.id.fragment_container, new Cost_Fragment());
                fr.commit();



            case R.id.btnerrandaghprofile:   //Request Button. Instantiates/Calls Package_Detail_Fragment Fragment when Clicked




                layout1.setVisibility( View.GONE );
                layout2.setVisibility( View.GONE );
                headlayout.setVisibility( View.GONE );
                btncontinue.setVisibility( View.GONE );

                layoutwebview.setVisibility( View.VISIBLE );

                String url = "https://web.facebook.com/pg/errandaservicegh137/about/?ref=page_internal";
                webView.setWebViewClient( new myWebViewClient() );
                webView.getSettings().setJavaScriptEnabled( true );
                webView.getSettings().setLoadsImagesAutomatically( true );
                webView.setScrollBarStyle( View.SCROLLBARS_INSIDE_OVERLAY );
                webView.loadUrl( url );

                FragmentTransaction partner = getFragmentManager().beginTransaction();
                partner.addToBackStack( null );
                break;
        }
    }




    public class myWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stubsuper.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl( url );
            return true;

        }
    }




    private void okMethod(){
        Log.d(TAG, "okMethod: Called");
    }

    public void customDialog(String title, String message, final String cancelMethod, final String okMethod ){
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder(getActivity());

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













