package com.example.Erranda;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.fragment.app.FragmentActivity;

public class progressBar {


    private static ProgressBar mProgressBar;

    public progressBar(FragmentActivity context) {
        ViewGroup layout = (ViewGroup) (( Activity ) context).findViewById(android.R.id.content)
                .getRootView();

        mProgressBar = new ProgressBar( ( Context ) context, null, android.R.attr.progressBarStyleLarge);
        mProgressBar.setIndeterminate(true);



        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        RelativeLayout rl = new RelativeLayout( ( Context ) context );

        rl.setGravity( Gravity.CENTER);
        rl.addView(mProgressBar);

        layout.addView(rl, params);

        hide();

    }


    public static void show() {
      mProgressBar.setVisibility( View.VISIBLE);
    }

    public static void hide() {

        mProgressBar.setVisibility(View.INVISIBLE);
    }











}
