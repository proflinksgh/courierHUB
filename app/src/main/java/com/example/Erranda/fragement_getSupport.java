
//Displays all Customer Transaction and provides addtional Query Options

package com.example.Erranda;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.android.volley.VolleyLog.TAG;

public class fragement_getSupport extends Fragment implements View.OnClickListener {

    ImageView imgBack;
    private LinearLayout headselect, headButton;
    boolean check = false, isQueue = false, isIntransit = false, isDelivered = false, isShipped = false, isDefault = false;
    Button queue, request, intransit, delivered, shipped;
    TextView tvtransit, tvshipped, tvqueue, tvdelivered, tvcall, tvmessage, tvchat;
    private RadioButton radioButton;
    private LinearLayout radioLayout, topMargin, labels;
    String strProblem = "";
    Button btntel, btnchat, btnmail, btnsubmit, btnhelp;
    TextView title_status, tvselect;
    ProgressBar progressBar;

    EditText etrequestid;

    Boolean isError = false;

    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.getsupport_fragment, container, false );


        etrequestid = ( EditText ) rootView.findViewById( R.id.etrequestid );
        title_status = ( TextView ) rootView.findViewById( R.id.title_status );
        tvcall = ( TextView ) rootView.findViewById( R.id.tvcall );
        tvmessage = ( TextView ) rootView.findViewById( R.id.tvmessage );
        tvchat = ( TextView ) rootView.findViewById( R.id.tvchat );


        tvselect = ( TextView ) rootView.findViewById( R.id.tvselect );
        radioLayout = ( LinearLayout ) rootView.findViewById( R.id.radiolayout );
        headButton = ( LinearLayout ) rootView.findViewById( R.id.headbutton );
      //  headselect = ( LinearLayout ) rootView.findViewById( R.id.headselect );
        topMargin = ( LinearLayout ) rootView.findViewById( R.id.topMargin );
        btntel = ( Button ) rootView.findViewById( R.id.btntel );
     //   btnhelp = ( Button ) rootView.findViewById( R.id.btnhelp );
        btnchat = ( Button ) rootView.findViewById( R.id.btnchat );
        btnmail = ( Button ) rootView.findViewById( R.id.btnmail );
        btnsubmit = ( Button ) rootView.findViewById( R.id.btnsubmit );
        imgBack = ( ImageView ) rootView.findViewById( R.id.back );
       // labels = ( LinearLayout ) rootView.findViewById( R.id.labels );


//         progressBar = (ProgressBar ) rootView.findViewById( R.id.progressBar );

        imgBack.setOnClickListener( ( View.OnClickListener ) this );
        btntel.setOnClickListener( ( View.OnClickListener ) this );
        btnchat.setOnClickListener( ( View.OnClickListener ) this );
        btnmail.setOnClickListener( ( View.OnClickListener ) this );
        btnsubmit.setOnClickListener( ( View.OnClickListener ) this );


         radioGroup = ( RadioGroup ) rootView.findViewById( R.id.radioproblem );
        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rb1:

                        strProblem = "I'm unable to submit request";
                        //btnsubmit.setVisibility(View.VISIBLE  );

                        break;

                    case R.id.rb2:

                        strProblem = "Unable to pay with Mobile money";
                        //btnsubmit.setVisibility(View.VISIBLE  );

                        break;


                    case R.id.rb3:

                        strProblem = "I'm unable to check my status";
                        //btnsubmit.setVisibility(View.VISIBLE  );

                        break;


                    case R.id.rb4:

                        strProblem = "I'm unable to reach rider";
                        //btnsubmit.setVisibility(View.VISIBLE  );

                        break;


                    case R.id.rb5:

                        //  btnsubmit.setVisibility(View.VISIBLE  );
                        strProblem = "Package delay in getting to destination";

                        break;


                    case R.id.rb6:

                        //    btnsubmit.setVisibility(View.VISIBLE  );
                        strProblem = "Package not delivered to me";

                        break;


                    case R.id.rb7:

                        //  btnsubmit.setVisibility(View.VISIBLE  );
                        strProblem = "Wrong package delivered to me";

                        break;


                    case R.id.rb8:

                        // btnsubmit.setVisibility(View.VISIBLE  );
                        strProblem = "Package is damaged";

                        break;
                }
            }
        } );


        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.back:

                etrequestid.setVisibility( View.GONE );
//                labels.setVisibility( View.VISIBLE );
                topMargin.setVisibility( View.VISIBLE );
              //  headselect.setVisibility( View.INVISIBLE );
                imgBack.setVisibility( View.INVISIBLE );
                btnchat.setVisibility( View.VISIBLE );
                btnmail.setVisibility( View.VISIBLE );
                btntel.setVisibility( View.VISIBLE );
                title_status.setText( "Get Support" );
                radioLayout.setVisibility( View.GONE );
                btnsubmit.setVisibility( View.GONE );

                tvcall.setVisibility( View.VISIBLE );
                tvchat.setVisibility( View.VISIBLE );
                tvmessage.setVisibility( View.VISIBLE );


                break;

            case R.id.btnsubmit:


                //Call API

                if(strProblem.equalsIgnoreCase( "" )){

                    isError = true;
                    customDialog( "Error", "No problem selected", "", "okMethod" );
                }


                else {


                    RequestQueue queue = Volley.newRequestQueue( getActivity() );
                    queue.start();

                    String requestid = etrequestid.getText().toString();

                    String url = Constant.url + "cust_message";
                    Log.d( "Output", "URL is " + url );
                    Log.d( "Output", "User Id " + Constant.userId );


                    com.example.Erranda.progressBar.show();
                    StringRequest sr = new StringRequest( Request.Method.POST, url, new Response.Listener <String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.d( "Output", "API Response " + response );

                            if (response.equalsIgnoreCase( null ) || response.equalsIgnoreCase( "null" )) {

                                com.example.Erranda.progressBar.hide();
                                customDialog( "Error", "Check Internet Connection", "", "okMethod" );
                            } else if (response.equalsIgnoreCase( "Successful" )) {

                                isError = false;
                                com.example.Erranda.progressBar.hide();
                                customDialog( "Successful", "Message sent successfully..... Our support team will contact you soon", "", "okMethod" );
                            } else {

                                isError = true;
                                com.example.Erranda.progressBar.hide();
                                customDialog( "Error", "Invalid Serial Number", "", "okMethod" );
                            }
                        }

                    }, new Response.ErrorListener() {


                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d( "Output", "Error" + error );

                            if (error.toString().contains( "Connection failed" )) {
                                customDialog( "Error", "Connection error...", "", "okMethod" );
                            }


                        }
                    } ) {
                        @Override
                        public byte[] getBody() throws AuthFailureError {
                            HashMap <String, String> params = new HashMap <String, String>();
                            params.put( "USER_ID", Constant.userId );
                            params.put( "REQUEST_ID", requestid );
                            params.put( "ISSUE", strProblem );
                            return new JSONObject( params ).toString().getBytes();

                        }


                        @Override
                        public String getBodyContentType() {
                            return "application/json";
                        }
                    };
                    queue.add( sr );

                }

                break;

            case R.id.btnmail:

               // headselect.setVisibility( View.GONE );

                radioGroup.setVisibility( View.VISIBLE );
                etrequestid.setVisibility( View.VISIBLE );
                btnsubmit.setVisibility(View.VISIBLE  );
    //            labels.setVisibility( View.GONE );
                topMargin.setVisibility( View.VISIBLE );
                imgBack.setVisibility( View.VISIBLE );
                btnchat.setVisibility( View.GONE );
                btntel.setVisibility( View.GONE );
                btnmail.setVisibility( View.GONE );
//                headselect.setVisibility( View.VISIBLE );
                title_status.setText("Send us a Message");
                radioLayout.setVisibility( View.VISIBLE );

                tvcall.setVisibility( View.GONE  );
                tvchat.setVisibility( View.GONE  );
                tvmessage.setVisibility( View.GONE  );





                break;

            case R.id.btntel:
                labels.setVisibility( View.VISIBLE );
                topMargin.setVisibility( View.VISIBLE );
              //  headselect.setVisibility( View.INVISIBLE );
                imgBack.setVisibility(View.INVISIBLE);
                btnchat.setVisibility( View.VISIBLE );
                btnmail.setVisibility( View.VISIBLE );
                btntel.setVisibility( View.VISIBLE );
                radioLayout.setVisibility( View.INVISIBLE );
                btnsubmit.setVisibility( View.GONE );


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData( Uri.parse("tel:0247058668"));
                startActivity(intent);

                break;


            case R.id.btnchat:
                labels.setVisibility( View.VISIBLE );
                topMargin.setVisibility( View.VISIBLE );
             //   headselect.setVisibility( View.INVISIBLE );
                imgBack.setVisibility(View.INVISIBLE);
                btnchat.setVisibility( View.VISIBLE );
                btnmail.setVisibility( View.VISIBLE );
                btntel.setVisibility( View.VISIBLE );
                radioLayout.setVisibility( View.INVISIBLE );
                btnsubmit.setVisibility( View.GONE );



                String link = "https://api.whatsapp.com/send?phone="+"+233247058668";
               // String url = " https://chat.whatsapp.com/JdME6thU2kI7piLnFtsbLq";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                startActivity(i);

                break;


        }
    }


    private void okMethod() {

        if (isError) {

        } else {

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack( null );
            fragmentTransaction.replace( R.id.fragment_container, new fragement_getSupport() );  //Instantiates fragment_status_view Fragment after if Retrieval is Successfuls
            fragmentTransaction.commit();
        }
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

















