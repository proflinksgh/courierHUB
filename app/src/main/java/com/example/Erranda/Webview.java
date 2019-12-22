package com.example.Erranda;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


public class Webview extends AppCompatActivity {


    WebView myWebView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.fragment_webview );


        viewpdf();
        finish();
    }


    public void viewpdf() {
       // String url = "https://facebook.com";
        String url = "https://drive.google.com/open?id=1Ac-wNQ5xw_gp9lXQPN3BqDcRPWNwjqa6";
        myWebView = ( WebView ) findViewById( R.id.webview );
        myWebView.getSettings().setJavaScriptEnabled( true );
        myWebView.getSettings().setLoadWithOverviewMode( true );
        myWebView.loadUrl( url );


    }
}