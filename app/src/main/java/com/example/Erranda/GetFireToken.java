package com.example.Erranda;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class GetFireToken  {

    public static void main(String[] args) {

        Log.d("Firebase", "token "+ FirebaseInstanceId.getInstance().getToken());
    }
}
