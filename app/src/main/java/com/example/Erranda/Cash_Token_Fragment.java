package com.example.Erranda;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


public class Cash_Token_Fragment extends Fragment {
    private static final String TAG = null;
    String JSON_STRING = "null";

    private TextView mLoadingText;
    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_cash_token, container, false );

        Button payment = rootView.findViewById( R.id.btnConfirm );
        TextView textView = ( TextView ) rootView.findViewById( R.id.tvID );


        Log.d( "Output", "token "+ Constant.token );

        textView.setText("");
        textView.setText( Constant.token );
        mProgressBar = ( ProgressBar ) rootView.findViewById( R.id.progressbar );




        payment.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                //Call API


                String url = Constant.url + "get_usern_token?username=" + Constant.username + "&token=" + Constant.token + "&partnerId=" + Constant.partnerId;


                Log.d( "Output", "Final URL " + url );

                Log.d( "Output", "Token " + Constant.token );
                Log.d( "Output", "Username " + Constant.username );
                Log.d( "Output", "Partner_Id " + Constant.partnerId );


                RequestQueue queue = Volley.newRequestQueue( getContext() );
                queue.start();

                progressBar progressBar = new progressBar( ( FragmentActivity ) getContext() );
                progressBar.show();

                StringRequest sr = new StringRequest( Request.Method.GET, url, new Response.Listener <String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d( "Output", "API Response " + response );

                        if (response.equalsIgnoreCase( null ) || response.equalsIgnoreCase( "null" )) {

                            progressBar.hide();
                            customDialog( "Error", "Check Internet Connection", "", "okMethod" );
                            //unsuccessful = true;
                        } else if (response.contains( "Successful" )) {

                            progressBar.hide();
                            customDialog( "Request Message", "Request submitted to " + Constant.selectedPartner + " Successfully", "cancelMethod", "okMethod" );
                            // dialogs.customDialog( "Error", "Login failed..... Incorrect email or password", "", "okMethod" );

                            //  unsuccessful = true;
                        } else {

                            progressBar.hide();
                            customDialog( "Error", "Connection failed", "", "okMethod" );
                            // unsuccessful = true;
                        }
                    }
                }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d( "Output", "Error" + error );

                        progressBar.hide();
                        if (error.toString().contains( "failed to connect to " + url )) {
                            customDialog( "Error", "Connection error...", "", "okMethod" );
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
        } );
        return rootView;
    }




    private void okMethod() {
        Log.d( TAG, "okMethod: Called" );
        //toastMessage( "OK Method" );

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.addToBackStack( null );
        fr.replace( R.id.fragment_container, new TaskList_Fragment() );
        fr.commit();

        mProgressBar.setVisibility( View.INVISIBLE );


    }


    public void customDialog(String title, String message, final String cancelMethod, final String okMethod) {
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder( getContext() );

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



















