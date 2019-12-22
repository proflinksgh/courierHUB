package com.example.Erranda;

import android.Manifest;
import android.content.Intent;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class Welcome_Fragment extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    private List <HashMap<String, String>> listofData = new ArrayList<>();
    Button btnproceed;

    VectorDrawable requestDraw;

    private final int INTERNET_PERMISSIONS = 101;
    private final int LOCATION_PERMISSIONS = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_welcome );

        mProgressBar = ( ProgressBar ) findViewById( R.id.progressbar );
        TextView message = ( TextView ) findViewById( R.id.tvPay );
        //      TextView terms = ( TextView ) findViewById( R.id.tvTerms );
        btnproceed = ( Button ) findViewById( R.id.btnproceed );


        requestNetworkSecurity();
    }

    private void requestLocationSecurity() {
        if(!EasyPermissions.hasPermissions( Welcome_Fragment.this, Manifest.permission.ACCESS_COARSE_LOCATION)){
            EasyPermissions.requestPermissions( Welcome_Fragment.this, getString(R.string.rationale_read_phone), LOCATION_PERMISSIONS,
                    Manifest.permission.ACCESS_COARSE_LOCATION);
        }else {
            validateUser();
        }

    }

    private void requestNetworkSecurity() {
        if(!EasyPermissions.hasPermissions( Welcome_Fragment.this, Manifest.permission.INTERNET)){
            EasyPermissions.requestPermissions( Welcome_Fragment.this, getString(R.string.rationale_read_phone), INTERNET_PERMISSIONS,
                    Manifest.permission.INTERNET);
        }else {
           requestLocationSecurity();
        }

    }



    private void validateUser() {

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
                        mProgressBar.setVisibility( View.GONE );

                        Intent intent = new Intent( Welcome_Fragment.this, Register.class );
                        startActivity( intent );

                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        finish();
                    }

                } );
            }
        } ).start();


    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, Welcome_Fragment.this);

    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
       /* Utils.showAlert(getActivity(), "Permission", "Permission Granted");
        if (requestCode == INTERNET_PERMISSIONS){
            validateUser();
        }*/

       validateUser();

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
       /* if(requestCode == INTERNET_PERMISSIONS){
            EasyPermissions.requestPermissions(Welcome_Fragment.this, getString(R.string.rationale_memory), INTERNET_PERMISSIONS, Manifest.permission.INTERNET);
        }*/
        if(requestCode == LOCATION_PERMISSIONS){
            EasyPermissions.requestPermissions( Welcome_Fragment.this, getString(R.string.rationale_read_phone), LOCATION_PERMISSIONS, Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}