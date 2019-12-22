package com.example.Erranda;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import dmax.dialog.SpotsDialog;


public class Payment_Options_Fragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "Cancelled";

    //Connector Variables

    EditText city, residence, contact;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_payment_options, container, false );


        Button momo = rootView.findViewById( R.id.btnMomo );
        Button cash = rootView.findViewById( R.id.btnCash );

        momo.setOnClickListener( ( View.OnClickListener ) this );
        cash.setOnClickListener( ( View.OnClickListener ) this );

    return rootView;
    }


    @Override

    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnMomo:


                final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( getContext() ).build();
                alertDialog.setTitle( "" );
                alertDialog.setMessage( " Please wait....." );
                alertDialog.show();

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        alertDialog.cancel();


                        //UUID is automatically Generated when user click MOMO
                        UUID uuid = UUID.randomUUID();
                        Constant.randomUUIDString = uuid.toString();


                        System.out.println( "Random UUID String = " + Constant.randomUUIDString );


                        GetToken token = new GetToken();
                        token.execute();


                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed( progressRunnable, 2000 );


                break;


            case R.id.btnCash:


                String type = "getid";
                GetID getID = new GetID();
                getID.execute();

                Log.d( "CREATION", "GETID is executed " );

        }
    }


    public class GetID extends Async {

        String username = Constant.username;

        public GetID() {

            url_link = "http://192.168.1.2/GetID.php";

            try {
                post_data = URLEncoder.encode( "username", "UTF-8" ) + "=" + URLEncoder.encode( username, "UTF-8" );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... params) {

            return super.doInBackground( username );
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute( result );

            Constant.ReqID = Constant.data.substring( 8 ); //Contains Request ID

            Constant.ReqID = Constant.ReqID.substring( 0, Constant.ReqID.length() - 5 );
            Log.d( "CREATION", "THE FINAL RESULT IS " + Constant.ReqID );

            if (!Constant.data.equals( "Unsuccesful" ) || (Constant.data != null)) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.addToBackStack( null );
                fr.replace( R.id.fragment_container, new Cash_Token_Fragment() );
                fr.commit();

            }
        }

    }


        public class GetToken extends Async {
            public GetToken() {
                url_link = "http://192.168.1.2/token.php";

                post_data = "";
            }


            @Override
            protected String doInBackground(String... params) {

                return super.doInBackground();
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute( result );

                //PRINT RANDOM GENERATED TOKEN

                Constant.token = Constant.data;

                Log.d( "CREATION", "GENERATED RANDOM TOKEN IS  " + Constant.token );

                if (Constant.data != null) {


                    //GET Contact From database

                    GetContact contact = new GetContact();
                    contact.execute();
                }

            }


        }


        public class GetContact extends Async {


            String parsed = " ";
            String getContact = " ";

            String username = Constant.username;

            public GetContact() {

                url_link = "http://192.168.1.2/getContact.php";

                try {
                    post_data = URLEncoder.encode( "username", "UTF-8" ) + "=" + URLEncoder.encode( username, "UTF-8" );
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                return super.doInBackground( username );
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute( result );


                if (!Constant.data.equals( "Unsuccesful" ) || (Constant.data != null)) {


                    try {
                        JSONArray JA = new JSONArray( Constant.data );
                        for (int i = 0; i < JA.length(); i++) {
                            JSONObject JO = ( JSONObject ) JA.get( i );
                            parsed = "" + JO.get( "CONTACT" );

                            getContact = getContact + parsed + "\n";


                            Constant.ContExtract = getContact;

                            Log.d( "CREATION", "EXTRACTED CONTACT IS  " + Constant.ContExtract );


                            final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( getContext() ).build();
                            alertDialog.setTitle( "" );
                            alertDialog.setMessage( " Please wait....." );
                            alertDialog.show();

                            Runnable progressRunnable = new Runnable() {

                                @Override
                                public void run() {
                                    alertDialog.cancel();

                                    getMomoTransID momo = new getMomoTransID();
                                    momo.execute();

                                }
                            };

                            Handler pdCanceller = new Handler();
                            pdCanceller.postDelayed( progressRunnable, 1000 );


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
                    public class getMomoTransID extends Async {
                        public getMomoTransID() {

                            Constant.username = username;
                            url_link = "http://192.168.1.2/GetID.php";

                            try {
                                post_data = URLEncoder.encode( "username", "UTF-8" ) + "=" + URLEncoder.encode( username, "UTF-8" );
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        protected String doInBackground(String... params) {

                            return super.doInBackground( username );
                        }

                        @Override
                        protected void onPostExecute(String result) {
                            super.onPostExecute( result );

                            //Put Final Intent Here

                            Constant.ReqID = Constant.data.substring( 8 ); //Contains Request ID

                            Constant.ReqID = Constant.ReqID.substring( 0, Constant.ReqID.length() - 5 );
                            Log.d( "CREATION", "THE FINAL RESULT IS " + Constant.ReqID );

                            if (!Constant.data.equals( "Unsuccesful" ) || (Constant.data != null)) {

                                FragmentTransaction fr = getFragmentManager().beginTransaction();
                                fr.addToBackStack( null );
                                fr.replace( R.id.fragment_container, new Momo_info_Fragment() );
                                fr.commit();


                            }
                        }
                }
            }

        }















