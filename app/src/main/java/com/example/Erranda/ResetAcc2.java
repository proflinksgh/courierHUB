package com.example.Erranda;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class ResetAcc2 extends AppCompatActivity {

    //Connector Variables
    String check2 = "Unsuccessful";
    private static TextView Info = null, Info2 = null;
    TextView Code;
    String username;
    String password;
    String check = "Error......Check Internet Connection";

    String usern;
    int counter = 4;
    static EditText usr;


    Button submit;
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
        setContentView( R.layout.resetacc2 );

        mProgressBar = ( ProgressBar ) findViewById( R.id.progressbar );
        Button submit = findViewById( R.id.btnSubmit );
        usr = ( EditText ) findViewById( R.id.etUsername );
        Code = (TextView ) findViewById( R.id.tvCode );

        Code.setText( Constant.Contact);


        submit.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Constant.SentCode = Code.getText().toString();

                //Saved into VARIABLE for referencing

            }
        } );
    }


    class PostSms {
        public String PostSms() {
            try {
                // Construct data
                String apiKey = "apikey=" + "tcgFJRyF8Cdk-8QbiGuCThpknGaesgw2osgQpQboFHR";
                String message = "&message=" + Constant.SentCode;
                String sender = "&sender=" + "Reset Password";
                String numbers = "&numbers=" + "0247058668";

                // Send data
                HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
                String data = apiKey + numbers + message + sender;
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.getOutputStream().write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
                }
                rd.close();

                return stringBuffer.toString();
                } catch (Exception e) {
                System.out.println("Error SMS "+e);
                return "Error "+e;
            }
        }
    }
}
