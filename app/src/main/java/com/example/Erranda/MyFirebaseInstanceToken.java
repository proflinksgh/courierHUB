package com.example.Erranda;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MyFirebaseInstanceToken extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {

    }

}
