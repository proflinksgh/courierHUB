package com.example.Erranda;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarHandler {


    public static void show(View view, String text, int duration) {
        final Snackbar snackbar = Snackbar.make(view, text, duration);
        View sbView = snackbar.getView();

        TextView textView = (TextView)sbView.findViewById(com.google.android.material.R.id.snackbar_text);

        textView.setTextColor( Color.WHITE);
        textView.setTextSize(12);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

}
