package com.example.Erranda;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


// First Page after Splash_Fragment

public class Old_welc extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    private List <HashMap <String, String>> listofData = new ArrayList <>();
    Button btnproceed;

    VectorDrawable requestDraw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_welcome );

        mProgressBar = ( ProgressBar ) findViewById( R.id.progressbar );
        TextView message = ( TextView ) findViewById( R.id.tvPay );
        //      TextView terms = ( TextView ) findViewById( R.id.tvTerms );
        btnproceed = ( Button ) findViewById( R.id.btnproceed );



        new Thread( new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 70) {
                    mProgressStatus++;
                    SystemClock.sleep( 50 );
                    mHandler.post( new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress( mProgressStatus );
                        }
                    } );

                }
                mHandler.post( new Runnable() {
                    @Override
                    public void run() {


                        //Check if gps is enabled or not and then request user to enable it
                        LocationRequest locationRequest = LocationRequest.create();
                        locationRequest.setInterval( 10000 );
                        locationRequest.setFastestInterval( 5000 );
                        locationRequest.setPriority( LocationRequest.PRIORITY_HIGH_ACCURACY );

                        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest( locationRequest );

                        SettingsClient settingsClient = LocationServices.getSettingsClient( Old_welc.this );
                        Task <LocationSettingsResponse> task = settingsClient.checkLocationSettings( builder.build() );


                        task.addOnSuccessListener( Old_welc.this, new OnSuccessListener <LocationSettingsResponse>() {
                            @Override
                            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                                //  getDeviceLocation();
                            }
                        } );


                        task.addOnFailureListener( Old_welc.this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                if (e instanceof ResolvableApiException) {
                                    ResolvableApiException resolvable = ( ResolvableApiException ) e;
                                    try {
                                        resolvable.startResolutionForResult( Old_welc.this, 51 );
                                    } catch (IntentSender.SendIntentException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }
                        } );

                        Log.d("Output", "Execute");

                        mProgressBar.setVisibility( View.GONE );

                        Intent intent = new Intent( Old_welc.this, Register.class );
                        startActivity( intent );

                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        finish();
                    }

                } );
            }
        } ).start();


    }



    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}




