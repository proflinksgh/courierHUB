package com.example.Erranda;

import android.app.AlertDialog;
import android.content.Context;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Erranda.R;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import dmax.dialog.SpotsDialog;


public class Momo_info_Fragment extends Fragment implements View.OnClickListener {

    //Connector Variables

    private static final String jsonurl = "http://192.168.1.2/login2.php";
    private static final String TAG = "";
    private static TextView Info = null, Info2 = null;
    TextView tvJSON;
    String Cust_contact, Cust_amount;
    String check = "Error......Check Internet Connection";

    String usern[], userp[];
    int counter = 4;
    static EditText contact, amount;
    TextView tvInfo;


    Button login, create;
    String ConnectionResult = "";
    Boolean isSuccess = false;
    private Button validate;
    private Button reset;
    private Context text;
    private View view;

    //Progress Bar

    private ProgressBar mProgressBar;
    private TextView mLoadingText;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    public AlertDialog waitingDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_momo_payment, container, false );


        Button submit = rootView.findViewById( R.id.btnSubmit );
        Button cancel = rootView.findViewById( R.id.btnCancel );
        contact = ( EditText ) rootView.findViewById( R.id.etContact );


        // int Dig_Contact =  Constant.contact.length();
        // boolean CheckCont = (Dig_Contact == 10);



    String firstThree = Constant.ContExtract.substring( 0, 3 );

    boolean first = firstThree.equals( "024" );
    boolean second = firstThree.equals( "054" );
    boolean third = firstThree.equals( "055" );
    boolean Resultch = (first == true || second == true || third == true);

        Log.d("CREATION","Output of Result Check: "+Resultch );

        if(Resultch ==true)

    {

        contact.setText( Constant.ContExtract );
    }

        submit.setOnClickListener( ( View.OnClickListener ) this );
        cancel.setOnClickListener( ( View.OnClickListener ) this );

        return rootView;
    }




    @Override

    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnSubmit:

                Constant.contact = contact.getText().toString();

                if(Constant.contact.isEmpty()){
                Toast.makeText( getContext(), "Please Type a Valid Mtn Number ", Toast.LENGTH_LONG ).show();
                }

                else if(!Constant.contact.isEmpty()){



                //Check Contact String
                int Dig_Contact = Constant.contact.length();
                boolean CheckCont = (Dig_Contact == 10);


                String firstThree = Constant.contact.substring( 0, 3 );

                boolean first = firstThree.equals( "024" );
                boolean second = firstThree.equals( "054" );
                boolean third = firstThree.equals( "055" );
                boolean Resultch = (first == true || second == true || third == true) && CheckCont == true;

                Log.d( "CREATION", "Output of Result Check: " + Resultch );

                if (Resultch == true) {


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


                } else if (Resultch == false) {

                    Toast.makeText( getContext(), "Please Type a Valid Mtn Number ", Toast.LENGTH_LONG ).show();

                    contact.setText( "" );

                    }
                }

                break;


            case R.id.btnCancel:


                break;

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
                customDialog( "Mobile Money", "Request Submitted Successfully", "", "okMethod" );

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

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        //  fr.addToBackStack( null );
        fr.replace( R.id.fragment_container, new TaskList_Fragment() );
        fr.commit();
    }


    public void customDialog(String title, String message, final String cancelMethod, final String okMethod) {
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder( getContext() );

        //  builderSingle.setIcon( R.drawable.momo2 );
        builderSingle.setTitle( title );
        builderSingle.setMessage( message );

        builderSingle.setTitle( title );
        builderSingle.setMessage( message );


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

