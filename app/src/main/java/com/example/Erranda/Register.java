package com.example.Erranda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {

    private static final String TAG = null;

    private TextInputLayout usr, pas, con, conf;

   // final String url = "http://192.168.1.2:3000/create_user"; // your URL


    String username1, password1, confpass1, contact1;

    Button Create, login;
    TextView tvInfo;
    String check2 = "Successful";
    String errCheck = "Error...... Try Again";
    boolean conCheck, unsuccessful = false, isExist = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_register );


        Create = findViewById( R.id.btnCreate );
        login = findViewById( R.id.btnLogin );
        usr = findViewById( R.id.etUsername );
        pas = findViewById( R.id.etPassword );
        conf = findViewById( R.id.etConfPass );
        con = findViewById( R.id.etContact );

        RequestQueue queue = Volley.newRequestQueue( this );
        queue.start();


        JsonParser parser = new JsonParser();


        login.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent( Register.this, Login.class );
                startActivity( intent );

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();

            }
        } );


        Create.setOnClickListener( new View.OnClickListener() {

            //  @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                username1 = usr.getEditText().getText().toString().trim();
                Constant.username = username1;  //This Copy is displayed after Creating Account at Sign In
                Constant.StrCnt1 = username1.length();


                if (username1.isEmpty()) {
                    usr.setError( "Field can't Empty" );
                } else {
                    usr.setError( null );
                    usr.setErrorEnabled( false );
                }


                password1 = pas.getEditText().getText().toString().trim();
                Constant.StrCnt = password1.length();//Count Password
                Constant.password = password1;

                if (password1.isEmpty()) {
                    pas.setError( "Field can't Empty" );
                } else {
                    pas.setError( null );
                    pas.setErrorEnabled( false );
                }


                confpass1 = conf.getEditText().getText().toString().trim();

                if (confpass1.isEmpty()) {
                    conf.setError( "Field can't Empty" );
                } else {
                    conf.setError( null );
                    conf.setErrorEnabled( false );
                }


                contact1 = con.getEditText().getText().toString().trim();

                if (contact1.isEmpty()) {
                    con.setError( "Field can't Empty" );
                } else {
                    con.setError( null );
                    con.setErrorEnabled( false );
                }


                Constant.StrCnt6 = contact1.length();

                // boolean su =(!username1.matches( "[a-zA-Z]+"));
                boolean su = !username1.contains( "@" );

                boolean su1 = (Constant.StrCnt1 < 3);

                boolean sum = (su1 == true || su == true);

                if (su == true) {
                    Toast.makeText( getApplicationContext(), "Invalid Email Entered", Toast.LENGTH_LONG ).show();

                    // usr.setText("");
                }

                if (su1 == true) {
                    Toast.makeText( getApplicationContext(), "Username should be more than two characters", Toast.LENGTH_LONG ).show();
                }

                //Condition for Password
                if (Constant.StrCnt <= 5) {
                    Toast.makeText( getApplicationContext(), "Password should be more than five characters", Toast.LENGTH_LONG ).show();
                    //   pas.setText("");
                    password1 = "";
                }
                boolean sum1 = (Constant.StrCnt <= 5);

                if (!confpass1.equalsIgnoreCase( password1 )) {

                    Toast.makeText( getApplicationContext(), "Password do not match", Toast.LENGTH_LONG ).show();
                }

                boolean sum2 = (!confpass1.equalsIgnoreCase( password1 ));

                //Condition for Contacts
                if (Constant.StrCnt6 != 10) {
                    Toast.makeText( getApplicationContext(), "Invalid Contact", Toast.LENGTH_LONG ).show();
                    // con.setText( "" );
                    contact1 = "";
                }

                boolean sum5 = (Constant.StrCnt6 != 10);

                conCheck = ((sum == false) && (sum1 == false) && (sum2 == false) && (sum5 == false));


                Log.d( "CREATION", "CONCHECK IS " + conCheck );
                Log.d( "CREATION", "SUM IS " + sum );
                Log.d( "CREATION", "SU IS " + su );
                Log.d( "CREATION", "SU1 IS " + su1 );


                if (conCheck == true) {


                    //API Call to Check if Username already exist


                    String url = Constant.url + "user_check?username=" + username1;

                    RequestQueue queue = Volley.newRequestQueue( Register.this );
                    queue.start();

                    progressBar progressBar = new progressBar( Register.this );
                    progressBar.show();

                    StringRequest sr = new StringRequest( Request.Method.GET, url, new Response.Listener <String>() {


                        @Override
                        public void onResponse(String response) {
                            Constant.response = response;

                            try {

                                JSONArray objArray = new JSONArray( response );
                                Log.d( "Ouput", "Check API response " + response );


                                for (int k = 0; k < objArray.length(); k++) {

                                    JSONObject objChild = objArray.getJSONObject( k );
                                    HashMap <String, String> map = new HashMap <>();
                                    map.put( "USERNAME", objChild.getString( "USERNAME" ) );

                                    if (map.put( "USERNAME", objChild.getString( "USERNAME" ) ).equalsIgnoreCase( username1 )) {

                                        progressBar.hide();
                                        isExist = true;
                                        unsuccessful = true;

                                        customDialog( "Error", "User Already Exist", "", "okMethod" );
                                    }
                                }


                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }



                            if (response.equalsIgnoreCase( "[]" )) {


                                //Call API


                                String link = Constant.url + "create_user";
                                Log.d( "Output", "URL is " + link );

                                progressBar.show();
                                StringRequest srt = new StringRequest( Request.Method.POST, link, new Response.Listener <String>() {
                                    @Override
                                    public void onResponse(String response) {

                                        Log.d( "Output", "API Response " + response );

                                        if (response.equalsIgnoreCase( null ) || response.equalsIgnoreCase( "null" )) {

                                            progressBar.hide();
                                            customDialog( "Error", "Check Internet Connection", "", "okMethod" );
                                            unsuccessful = true;
                                        } else if (response.equalsIgnoreCase( "Successful" )) {

                                            progressBar.hide();

                                            unsuccessful = false;

                                            customDialog( "Account", "Account Created Successfully", "", "okMethod" );
                                        } else {

                                            progressBar.hide();
                                            customDialog( "Error", "Something went wrong.... Try Again", "", "okMethod" );
                                            unsuccessful = true;
                                        }
                                    }
                                }, new Response.ErrorListener() {


                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.d( "Output", "Error" + error );

                                        if (error.toString().contains( "Connection failed" )) {
                                            customDialog( "Error", "Connection error...", "", "okMethod" );
                                            unsuccessful = true;
                                        }

                                    }
                                } ) {
                                    @Override
                                    public byte[] getBody() throws AuthFailureError {
                                        HashMap <String, String> params = new HashMap <String, String>();
                                        params.put( "USERNAME", username1 );
                                        params.put( "PASSWORD", password1 );
                                        params.put( "CONTACT", contact1 );
                                        return new JSONObject( params ).toString().getBytes();
                                    }


                                    @Override
                                    public String getBodyContentType() {
                                        return "application/json";
                                    }
                                };
                                queue.add( srt );
                            }


                        }

                    }, new Response.ErrorListener() {


                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d( "Output", "Error" + error );

                            progressBar.hide();
                            if (error.toString().contains( "failed to connect" )) {
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
                }

//                    if(isExist&&!Constant.response.equalsIgnoreCase( "[]" )){
            }
        } );
    }




    private void okMethod(){
        Log.d(TAG, "okMethod: Called");
        if(unsuccessful){

   }

   else {

       Intent i = new Intent( Register.this, Sign.class );
       startActivity( i );
   }

   unsuccessful = false;

    }


    public void customDialog(String title, String message, final String cancelMethod, final String okMethod ){
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder(this);

        builderSingle.setIcon( R.drawable.acc );
        builderSingle.setTitle( title );
        builderSingle.setMessage(message);

        builderSingle.setCancelable( false );

        builderSingle.setPositiveButton(

                "Continue",
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

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

















