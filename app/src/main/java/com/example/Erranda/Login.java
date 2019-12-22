


package com.example.Erranda;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static com.android.volley.VolleyLog.TAG;

public class Login extends AppCompatActivity  implements LocationListener {

    //Connector Variables

    TextView locationText;

    LocationManager locationManager;


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




        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }




        login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            getLocation();


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

            RequestQueue queue = Volley.newRequestQueue( Login.this);
            queue.start();

            progressBar progressBar = new progressBar( Login.this );
            progressBar.show();

            StringRequest sr = new StringRequest( Request.Method.GET, url, new Response.Listener <String>() {



                @Override
                public void onResponse(String response) {

                    Log.d( "Ouput", "Server availabilty " + response );


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
                                Intent i = new Intent( Login.this, MainActivity.class );
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
                    if(error.toString().contains( "com.android.volley.ClientError")){

                        customDialog( "Error", "Server unavailable.... Try again", "", "okMethod" );
                    }

                    else if(error.toString().contains( "com.android.volley.NoConnectionError: java.net.UnknownHostException:" )){
                        customDialog( "Connection Error", "Check your Internet and try again", "", "okMethod" );
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
    });


      register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent( Login.this, Register.class );
            startActivity( intent );
        }
    });


    }




    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);

            //String locat =  locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this).to;
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
     //  Constant.mylocation = ("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());

       Constant.latitude = location.getLatitude();
       Constant.longitude = location.getLongitude();


        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List <Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);


            Constant.mylocation = (locationText.getText() + "\n"+addresses.get(0).getAddressLine(0));/*+", "+
                     addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2)); */

            Log.d("Output", "Location is "+Constant.mylocation);

         }catch(Exception e)
        {

        }

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(Login.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();

        Log.d( "CREATION", "Provider is  " + provider );
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {


    }

    @Override
    public void onProviderEnabled(String provider) {

    }






    private void cancelMethod() {

    }

    private void okMethod() {

    }


    public void customDialog(String title, String message, final String cancelMethod, final String okMethod) {
        final androidx.appcompat.app.AlertDialog.Builder builderSingle = new androidx.appcompat.app.AlertDialog.Builder( Login.this );

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
        Toast.makeText( Login.this, message, Toast.LENGTH_SHORT ).show();
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack( true );
    }

}