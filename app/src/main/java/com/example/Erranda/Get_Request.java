package com.example.Erranda;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Get_Request {
    public static void main(String[] args) throws IOException {


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox.momodeveloper.mtn.com/collection/v1_0/requesttopay/"+ Constant.randomUUIDString+"")
                .get()
                .addHeader("Authorization", "Bearer "+ Constant.token)
                .addHeader("Ocp-Apim-Subscription-Key", Constant.key)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Target-Environment", "sandbox")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "1bb95fd1-4278-4b8f-bda7-cf54b0785f72")
                .build();

        Response response = client.newCall(request).execute();

        Constant.getOutput = response.toString();

    }
}






