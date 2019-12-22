package com.example.Erranda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import dmax.dialog.SpotsDialog;

import static com.android.volley.VolleyLog.TAG;


public class Cost_Fragment extends Fragment implements View.OnClickListener {

    private List <HashMap <String, String>> listofData = new ArrayList <>();
    private List <String> tokenList = new ArrayList <>();
    private TextView mLoadingText, tvSelection;
    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    LinearLayout PayOption, btnAcceptDecline, Proceed;
    private RadioButton radioButton;
    int PayOptionId = 0;
    static EditText contact;

    TextView tvamount;
    String firstThree = "";
    boolean first, second, third, fourth, CheckCont, mtnmomCheck, airteltigoCheck, vodafonecashCheck;
    int Dig_Contact = 0;

    static RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_cost, container, false );

        Button accept = rootView.findViewById( R.id.btnConfirm );
        Button decline = rootView.findViewById( R.id.btnDecline );
        Button Submit = rootView.findViewById( R.id.btnsubmit );
        PayOption = ( LinearLayout ) rootView.findViewById( R.id.payoption );
        btnAcceptDecline = ( LinearLayout ) rootView.findViewById( R.id.btnacceptdecline );
        contact = ( EditText ) rootView.findViewById( R.id.etContact );
        tvamount = (TextView ) rootView.findViewById( R.id.tvAmt );

        Submit.setOnClickListener( ( View.OnClickListener ) this );
        accept.setOnClickListener( ( View.OnClickListener ) this );
        decline.setOnClickListener( ( View.OnClickListener ) this );

        //addListenerOnButton();


        Log.d("Output", "Cost is "+ Constant.cost);
        tvamount.setText("GH¢"+Constant.cost+".00");

         radioGroup = ( RadioGroup ) rootView.findViewById( R.id.radiopayoption );

        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch (checkedId) {
                    case R.id.radiocash:


                        String url = Constant.url + "fetch_token";

                        RequestQueue queue = Volley.newRequestQueue( getActivity() );
                        queue.start();


                        //API CALL

                        StringRequest sr = new StringRequest( Request.Method.GET, url, new Response.Listener <String>() {
                            @Override
                            public void onResponse(String response) {

                                Log.d( "Output", "API Response " + response );
                                try {

                                    JSONArray objArray = new JSONArray( response );
                                    Log.d( "Ouput", "API response " + response );

                                    if (objArray.length() == 0) {
                                        //  Utils.showToast( getActivity(), getString( R.string.No_data ) );
                                    } else {

                                        for (int k = 0; k < objArray.length(); k++) {

                                            JSONObject objChild = objArray.getJSONObject( k );
                                            HashMap <String, String> map = new HashMap <>();
                                            map.put( "PAYMENT_CODE", objChild.getString( "PAYMENT_CODE" ) );

                                            listofData.add( map );
                                            Constant.token = map.get("PAYMENT_CODE");
                                        }

//                                        for (HashMap <String, String> fillmap : listofData) {
//                                            tokenList.add( fillmap.get( "PAYMENT_CODE" ) );
//                                        }
//
//                                        Constant.token = tokenList.toString();
//                                        Log.d( "Output", "Final Token " + tokenList );
//
//                                        Constant.token = Constant.token.substring(1, Constant.token.length() - 1);

                                    }


                                    progressBar.hide();
                                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                                    fr.addToBackStack( null );
                                    fr.replace( R.id.fragment_container, new Cash_Token_Fragment() );
                                    fr.commit();

                                   radioGroup.clearCheck();


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
                                if (error.toString().contains( "failed to connect to " +url )) {
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


                        break;

                    case R.id.radioairteltigo:


                        contact.setVisibility( View.VISIBLE );
                        Submit.setVisibility( View.VISIBLE );
                        contact.setHint( "Enter AirtelTigo Number" );
                        PayOptionId = 2;


                        //Set Conditions

                        //Check Contact String
                        //  radioButton.setEnabled(false);


                        break;


                    case R.id.radiovoda:


                        contact.setVisibility( View.VISIBLE );
                        Submit.setVisibility( View.VISIBLE );
                        contact.setHint( "Enter Vodafone Number" );

                        PayOptionId = 4;

                        break;


                    case R.id.radiomtn:


                        contact.setVisibility( View.VISIBLE );
                        Submit.setVisibility( View.VISIBLE );
                        contact.setHint( "Enter MTN Number" );
                        PayOptionId = 3;


                        break;

                }
            }
        } );


        return rootView;
    }





    @Override

    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.btnConfirm:


                //Display Progressbar

                        btnAcceptDecline.setVisibility( View.GONE );
                        PayOption.setVisibility( View.VISIBLE );

                break;


            case R.id.btnDecline:


                //API to Delete Transaction by ID from cust_req_tb


                break;


            case R.id.btnsubmit:


                Constant.contact = contact.getText().toString();

                if (Constant.contact.isEmpty()) {
                    Toast.makeText( getContext(), "Enter Mobile Number", Toast.LENGTH_LONG ).show();
                } else if (!Constant.contact.isEmpty()) {

                    switch (PayOptionId) {
                        case 2:

                            Dig_Contact = Constant.contact.length();
                            CheckCont = (Dig_Contact == 10);

                            firstThree = Constant.contact.substring( 0, 3 );
                            first = firstThree.equals( "027" );
                            second = firstThree.equals( "057" );
                            third = firstThree.equals( "056" );
                            fourth = firstThree.equals( "026" );


                            airteltigoCheck = (first == true || second == true || third == true || fourth == true) && CheckCont == true;

                            if (airteltigoCheck == true) {

                                //Set Params

                                final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( getContext() ).build();
                                alertDialog.setTitle( "" );
                                alertDialog.setMessage( " Please wait....." );
                                alertDialog.show();

                                Runnable progressRunnable = new Runnable() {

                                    @Override
                                    public void run() {
                                        alertDialog.cancel();


                                        customDialog( "Oops", "Mobile payment not valid in this release. Please select cash", "", "okMethod" );


//                                        //UUID is automatically Generated when user click MOMO
//                                        UUID uuid = UUID.randomUUID();
//                                        Constant.randomUUIDString = uuid.toString();
//
//
//                                        System.out.println( "Random UUID String = " + Constant.randomUUIDString );
//
//                                        Log.d( "CREATION", "Random UUID Generated " + Constant.randomUUIDString );
//
//                                        GetToken token = new GetToken();
//                                        token.execute();

                                    }
                                };

                                Handler pdCanceller = new Handler();
                                pdCanceller.postDelayed( progressRunnable, 2000 );


                            } else {
                                Toast.makeText( getContext(), "Invalid AirtelTigo Number ", Toast.LENGTH_LONG ).show();
                            }

                            break;


                        case 3:

                            Constant.contact = contact.getText().toString();

                            Dig_Contact = Constant.contact.length();
                            CheckCont = (Dig_Contact == 10);

                            firstThree = Constant.contact.substring( 0, 3 );
                            first = firstThree.equals( "024" );
                            second = firstThree.equals( "054" );
                            third = firstThree.equals( "055" );

                            mtnmomCheck = (first == true || second == true || third) && CheckCont == true;

                            if (Constant.contact.isEmpty()) {
                                Toast.makeText( getContext(), "Enter AirtelTigo Number ", Toast.LENGTH_LONG ).show();
                            } else if (mtnmomCheck == true) {

                                //Set Params

                                final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( getContext() ).build();
                                alertDialog.setTitle( "" );
                                alertDialog.setMessage( " Please wait....." );
                                alertDialog.show();

                                Runnable progressRunnable = new Runnable() {

                                    @Override
                                    public void run() {
                                        alertDialog.cancel();


//                                        //UUID is automatically Generated when user click MOMO
//                                        UUID uuid = UUID.randomUUID();
//                                        Constant.randomUUIDString = uuid.toString();
//
//
//                                        System.out.println( "Random UUID String = " + Constant.randomUUIDString );

                                        customDialog( "Sorry", "Mobile payment not valid in this release. Please pay with Cash", "", "okMethod" );
//                                        GetToken token = new GetToken();
//                                        token.execute();

                                    }
                                };

                                Handler pdCanceller = new Handler();
                                pdCanceller.postDelayed( progressRunnable, 2000 );


                            } else {
                                Toast.makeText( getContext(), "Invalid Mtn Number ", Toast.LENGTH_LONG ).show();
                            }

                            break;

                        case 4:

                            Dig_Contact = Constant.contact.length();
                            CheckCont = (Dig_Contact == 10);

                            firstThree = Constant.contact.substring( 0, 3 );
                            first = firstThree.equals( "020" );
                            second = firstThree.equals( "050" );
                            vodafonecashCheck = (first == true || second == true) && CheckCont == true;

                            if (Constant.contact.isEmpty()) {
                                Toast.makeText( getContext(), "Enter Vodafone Number ", Toast.LENGTH_LONG ).show();
                            } else if (vodafonecashCheck == true) {

                                //Set Params

                                final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( getContext() ).build();
                                alertDialog.setTitle( "" );
                                alertDialog.setMessage( " Please wait....." );
                                alertDialog.show();

                                Runnable progressRunnable = new Runnable() {

                                    @Override
                                    public void run() {
                                        alertDialog.cancel();


                                        customDialog( "Sorry", "Mobile payment not valid in this release. Please pay with Cash", "", "okMethod" );


//                                        //UUID is automatically Generated when user click MOMO
//                                        UUID uuid = UUID.randomUUID();
//                                        Constant.randomUUIDString = uuid.toString();
//
//
//                                        System.out.println( "Random UUID String = " + Constant.randomUUIDString );
//
//
//                                        GetToken token = new GetToken();
//                                        token.execute();

                                    }
                                };

                                Handler pdCanceller = new Handler();
                                pdCanceller.postDelayed( progressRunnable, 2000 );


                            } else {
                                Toast.makeText( getContext(), "Invalid Vodafone Number ", Toast.LENGTH_LONG ).show();
                            }


                    }
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


                getMomoTransID getmomotransid = new getMomoTransID();
                getmomotransid.execute();
            }

        }

    }


    public class getMomoTransID extends Async {

        String username = Constant.username;

        public getMomoTransID() {

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

                final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( getContext() ).build();
                alertDialog.setTitle( "" );
                alertDialog.setMessage( " Processing....." );
                alertDialog.show();

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        alertDialog.cancel();


                        int SDK_INT = android.os.Build.VERSION.SDK_INT;
                        if (SDK_INT > 8) {
                            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                            StrictMode.setThreadPolicy( policy );

                            try {
                                Post_Request.main( null );
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }


                        //Condition to Check if Output Response from Server is Accepted
                        boolean isFound = Constant.output.contains( "message=Accepted" );
                        if (isFound == true) {


                            //Progress Dialog to Delay
                            final AlertDialog alertDialog = new SpotsDialog.Builder().setContext( getContext() ).build();
                            alertDialog.setTitle( "" );
                            alertDialog.setMessage( "Please wait....." );
                            alertDialog.show();


                            Runnable progressRunnable = new Runnable() {

                                @Override
                                public void run() {
                                    alertDialog.cancel();

                                    //GET Message to Check Status of Request

                                    try {
                                        Get_Request.main( null );

                                        Log.d( "CREATION", "Get Request Output is: " + Constant.getOutput );

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    //Condition to Check if Get Response from Server is Successful
                                    boolean isFound = Constant.getOutput.contains( "message=OK" );
                                    if (isFound == true) {

                                        MultiMomo momo = new MultiMomo();
                                        momo.execute();

                                    }

                                }

                            };

                            Handler pdCanceller = new Handler();
                            pdCanceller.postDelayed( progressRunnable, 5000 );

                        } else {
                            customDialog( "Error", "Server Error", "", "okMethod" );
                        }
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed( progressRunnable, 2000 );

            }
        }
    }


    public class MultiMomo extends Async {

        String user_name = Constant.username;
        String id = Constant.ReqID;
        String randomUUIDString = Constant.randomUUIDString;


        public MultiMomo() {
            url_link = "http://192.168.1.2/Momo_multi.php";

            try {
                post_data = URLEncoder.encode( "user_name", "UTF-8" ) + "=" + URLEncoder.encode( user_name, "UTF-8" ) + "&" + URLEncoder.encode( "id", "UTF-8" ) + "=" + URLEncoder.encode( id, "UTF-8" ) + "&" + URLEncoder.encode( "randomUUIDString", "UTF-8" ) + "=" + URLEncoder.encode( randomUUIDString, "UTF-8" );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            return super.doInBackground( user_name, id, randomUUIDString );
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute( result );

            if (Constant.data.equals( "Transaction Received Successfully" )) {

                //Final Intent Here
                String message = "";

                switch (PayOptionId) {
                    case 2:
                        message = "AirtelTigo";
                        break;

                    case 3:
                        message = "MTN";
                        break;

                    case 4:
                        message = "Vodafone";
                }

                customDialog( "Success", "Request Submitted Successfully. You will receive payment prompt from " + message + " soon", "", "okMethod" );
                //  Utils.showAlert(getActivity(), "success", "Request Submitted Successfully. You will receive payment prompt from " + message + " soon" );


            } else {
                Toast.makeText( getContext(), "Something went wrong", Toast.LENGTH_LONG ).show();
            }
        }
    }

    private void cancelMethod() {
        //   Log.d( TAG, "Cancelled." );
        // toastMessage( "Cancelled" );
    }

    private void okMethod() {

//        FragmentTransaction fr = getFragmentManager().beginTransaction();
//        //  fr.addToBackStack( null );
//        fr.replace( R.id.fragment_container, new TaskList_Fragment() );
//        fr.commit();
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


    public class BackgroundTask extends Async {

        String dataParsed = "";
        String singleParsed = "";

        public BackgroundTask() {
            url_link = "http://192.168.1.2/fetchcode.php";
            post_data = "";
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute( result );

            Log.d( "CREATION", "DATA IS" + Constant.data );

            Log.d( "CREATION", "PAYMENT CODE " + Constant.ParsedData );

            if (Constant.data == null) {
                Toast.makeText( getContext(), "Check Internet Connection", Toast.LENGTH_LONG ).show();
            } else if (!Constant.data.equals( "Unsuccesful[]" ) || (Constant.data != null)) {

           /*   FragmentTransaction fr = getFragmentManager().beginTransaction();
              fr.addToBackStack( null );
              fr.replace( R.id.fragment_container, new Payment_Options_Fragment() );
              fr.commit(); */

                try {
                    JSONArray JA = new JSONArray( Constant.data );
                    for (int i = 0; i < JA.length(); i++) {
                        JSONObject JO = ( JSONObject ) JA.get( i );
                        singleParsed = "PAYMENT_CODE:" + JO.get( "PAYMENT_CODE" );

                        dataParsed = dataParsed + singleParsed;
                        dataParsed = dataParsed.substring( 13 );
                        Constant.ParsedData = dataParsed;
                    }
                } catch (JSONException e) {
                }


            }
        }


        public class delCode extends Async {
            String id = Constant.ReqID;

            public delCode() {

                url_link = "http://192.168.1.2/removerec.php";


                try {
                    post_data = URLEncoder.encode( "id", "UTF-8" ) + "=" + URLEncoder.encode( id, "UTF-8" );
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                return super.doInBackground( id );
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute( result );

                if (Constant.data == null) {
                    Toast.makeText( getContext(), "Check Internet Connection", Toast.LENGTH_LONG ).show();
                } else if (Constant.data.equals( "Successful" )) {

                    new Thread( new Runnable() {
                        @Override
                        public void run() {


                            while (mProgressStatus < 70) {
                                mProgressStatus++;
                                android.os.SystemClock.sleep( 30 );
                                mHandler.post( new Runnable() {
                                    @Override
                                    public void run() {
                                        mProgressBar.setVisibility( View.VISIBLE );
                                        mProgressBar.setProgress( mProgressStatus );

                                    }
                                } );

                            }
                            mHandler.post( new Runnable() {
                                @Override
                                public void run() {

                                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                                    //  fr.addToBackStack( null );
                                    fr.replace( R.id.fragment_container, new TaskList_Fragment() );
                                    fr.commit();
                                    mProgressBar.setVisibility( View.INVISIBLE );
                                }
                            } );
                        }
                    } ).start();


                } else if (Constant.data.equals( "Usuccessful" )) {

                    Toast.makeText( getContext(), "Something went wrong", Toast.LENGTH_LONG ).show();
                }
            }

        }
    }
}

