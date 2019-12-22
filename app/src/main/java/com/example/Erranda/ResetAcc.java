package com.example.Erranda;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import androidx.appcompat.app.AppCompatActivity;

public class ResetAcc extends AppCompatActivity {

    private static final String TAG = null;
    //Connector Variables
    String check2 = "Unsuccessful";
    private static TextView Info = null, Info2 = null;
    TextView tvJSON;
    String username;
    String password;
    String check = "Error......Check Internet Connection";

    String usern;
    int counter = 4;
    static EditText usr;


    Button login;
    String ConnectionResult = "";
    Boolean isSuccess = false;
    private Button next;
    private Context text;
    private View view;

    //Progress Bar

    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.resetacc );

        mProgressBar = ( ProgressBar ) findViewById( R.id.progressbar );
        Button next = findViewById( R.id.btnNext );
        usr = ( EditText ) findViewById( R.id.etUsername );


        next.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                username = usr.getText().toString();

                //Saved into VARIABLE for referencing
                Constant.username = username;

                Constant.defUsern = username;

                String type = "reset";
                GetReset json = new GetReset(  );
                json.execute(  );

            }
        } );
    }

    public class GetReset extends Async{

        String user_name = Constant.username;


        public GetReset(){
            url_link = "http://192.168.1.2/resetacc.php";

            try{
                post_data = URLEncoder.encode( "user_name", "UTF-8" ) + "=" + URLEncoder.encode( user_name, "UTF-8" );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            return super.doInBackground( user_name);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute( s );

            if (s == null) {
                Toast.makeText( getApplicationContext(), "Check Internet Connection", Toast.LENGTH_LONG ).show();
            }

            else if (s.equals( "Unsuccessful[]")) {

                customDialog( " ", "Username not found", "cancelMethod", "okMethod" );
                mProgressBar.setVisibility( View.INVISIBLE );

            }

            else if (!s.equals( "Unsuccessful[]" ) || (s != null)) {

                Constant.Contact = s;
                Constant.Contact = s.substring( 34 );
                Constant.Contact = Constant.Contact.substring( 0, Constant.Contact.length() - 5 );

                new Thread( new Runnable() {
                    @Override
                    public void run() {


                        while (mProgressStatus < 50) {
                            mProgressStatus++;
                            android.os.SystemClock.sleep( 30 );
                            mHandler.post( new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setVisibility( View.VISIBLE );
                                    mProgressBar.setProgress( mProgressStatus );
                                    // mLoadingText.setVisibility( View.VISIBLE );
                                }
                            } );

                        }
                        mHandler.post( new Runnable() {
                            @Override
                            public void run() {


                                Intent i = new Intent( ResetAcc.this, ResetAcc2.class );
                                startActivity( i );

                                mProgressBar.setVisibility( View.INVISIBLE );
                            }
                        } );
                    }
                } ).start();


                //s = null;


            } else if (s.equals( "Error....Incorrect Username or Password[]" )) {
                Toast.makeText( getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_LONG ).show();
            }


        }

    }


    private void okMethod(){
        Log.d(TAG, "okMethod: Called");

        mProgressBar.setVisibility( View.INVISIBLE );
    }


    public void customDialog(String title, String message, final String cancelMethod, final String okMethod ){
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder(this);

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
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}



