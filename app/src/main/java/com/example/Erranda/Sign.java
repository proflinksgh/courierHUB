
//Login Page for Users


package com.example.Erranda;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import static com.android.volley.VolleyLog.TAG;

public class Sign extends AppCompatActivity  implements View.OnClickListener {

    //Connector Variables

    private static final String jsonurl = "http://192.168.1.2/login2.php";
    private static TextView Info = null, Info2 = null;
    TextView tvJSON;
    String username = "";
    String password;
    String check = "Error......Check Internet Connection";

    boolean unsuccessful = false;

    private TextInputLayout pas;
    EditText usr;


    Button login, create;
    String ConnectionResult = "";
    Boolean isSuccess = false;
    private Button validate;
    private Button reset;
    private Context text;
    private View view;
    TextView label;
    //Progress Bar

    private ProgressBar mProgressBar;
    private TextView mLoadingText;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    public AlertDialog waitingDialog;
    SharedPreferences myPrefs;

    TextInputLayout etPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_sign );



        mProgressBar = ( ProgressBar ) findViewById( R.id.progressbar );
        Button login = findViewById( R.id.btnLogin );
        Button register = findViewById( R.id.btnRegister );
        usr = ( EditText ) findViewById( R.id.etUsername );
        pas = findViewById( R.id.etPassword );
        tvJSON = ( TextView ) findViewById( R.id.tvJSON );
        etPassword = (TextInputLayout) findViewById( R.id.etPassword );
        EditText etpassword1 = (EditText ) findViewById( R.id.etPassword1 );




        if (!Constant.username.isEmpty()) {
            usr.setText( Constant.username );

        } else {
            usr.setText( "proflinksgh@gmail.com" );

        }


        login.setOnClickListener( ( View.OnClickListener ) this );
        register.setOnClickListener( ( View.OnClickListener ) this );


//
//        GPSTracker gpsTracker = new GPSTracker(this, 0);
//        if (gpsTracker.isGPSEnabled) {
//            new GPSTracker(this, 0 );
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Log.d("Output", "GPS Tracker executed");
//                    new GPSTracker(Sign.this, 0 );
//                }
//            }, 2000);
//        }
    }




    @Override

    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.btnLogin:    //Login Button

                username = usr.getText().toString();

                password = pas.getEditText().getText().toString().trim();


                if (password.isEmpty()) {

                    pas.setError( "Field can't be Empty" );
                } else {
                    pas.setError( null );
                    pas.setErrorEnabled( false );
                }


                //Saved into VARIABLE for referencing
                Constant.username = username;


                //Call API

                String url = Constant.url + "user_auth?username=" + username + "&password=" + password;

                Log.d("Password is ", "URL now "+ password);

                RequestQueue queue = Volley.newRequestQueue( this);
                queue.start();

                progressBar progressBar = new progressBar( Sign.this );
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
                                    map.put( "USERNAME", objChild.getString( "USERNAME" ) );
                                    map.put( "PASSWORD", objChild.getString( "PASSWORD" ) );
                                    map.put( "USER_ID", objChild.getString( "USER_ID" ) );

                                     Constant.userId = map.get("USER_ID");
                                     Constant.userName = map.get("USERNAME");
                                    if (map.put( "USERNAME", objChild.getString( "USERNAME" ) ).equalsIgnoreCase( username ) && (map.put( "PASSWORD", objChild.getString( "PASSWORD" ) ).equalsIgnoreCase( password ))) {

                                        progressBar.hide();
                                     Intent i = new Intent( Sign.this, MainActivity.class );
                                    startActivity( i );

                                        pas.getEditText().setText("");
                                   // finish();


                                    }
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }



                        if(response.equalsIgnoreCase( null )|| response.equalsIgnoreCase( "null" )){

                            progressBar.hide();
                            customDialog( "Error", "Check Internet Connection", "", "okMethod" );

                       } else if (response.contains( "[]" )) {

                            progressBar.hide();
                            customDialog( "Error", "Login failed.... Incorrect email or password", "", "okMethod" );
                        }

                    }
                }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Output", "Error"+ error);

                        progressBar.hide();
                        if(error.toString().contains( "failed to connect")){
                            customDialog( "Connection Error", "Check your Internet and try again", "", "okMethod" );
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

            case R.id.btnRegister: //Button for Creating Accounts

                Intent intent = new Intent( this, Register.class );
                startActivity( intent );

                break;

        }
    }




        private void cancelMethod() {

        }

        private void okMethod() {

        }


        public void customDialog(String title, String message, final String cancelMethod, final String okMethod) {
            final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder( Sign.this );

            //  builderSingle.setIcon( R.drawable.momo2 );
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
            Toast.makeText( Sign.this, message, Toast.LENGTH_SHORT ).show();
        }


    @Override
    public void onBackPressed() {
        moveTaskToBack( true );
    }
}
