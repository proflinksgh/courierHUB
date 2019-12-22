package com.example.Erranda;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Post_Request {


    public static void main(String[] args) throws IOException {


        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"amount\": "+ Constant.Cust_amount+",\r\n  \"currency\": \"EUR\",\r\n  \"externalId\": \"123456\",\r\n  \"payer\": {\r\n    \"partyIdType\": \"MSISDN\",\r\n    \"partyId\": "+ Constant.contact+"\r\n  },\r\n  \"payerMessage\": \"Hello\",\r\n  \"payeeNote\": \"Please pay up\"\r\n}");
        Request request = new Request.Builder()
                .url("https://sandbox.momodeveloper.mtn.com/collection/v1_0/requesttopay")
                .post(body)
                .addHeader("Authorization", "Bearer " + Constant.token)
                .addHeader("X-Reference-Id", Constant.randomUUIDString)
                .addHeader("Ocp-Apim-Subscription-Key", Constant.key)
                .addHeader("Content-Type", "application/json")
                .addHeader("X-Target-Environment", "sandbox")
                .addHeader("cache-control", "no-cache")
           //     .addHeader("Postman-Token", "bdd5fd17-1f8b-4d97-8bb2-9debe38a39ce")
                .addHeader( "Postman-Token", "06dd35bc-ddd1-4167-98bb-5fd979f0e7ba")
                .build();


        Log.d("CREATION", "Authorization"+Constant.token);
        Log.d("CREATION", "X-Reference-Id"+Constant.randomUUIDString);
        Log.d("CREATION", "Subscription"+Constant.key);
        Log.d("CREATION", "Amount"+Constant.Cust_amount);
        Log.d("CREATION", "Contact"+Constant.contact);





        Response response = client.newCall(request).execute();

        Constant.output = response.toString();

        System.out.println("The Output: " + Constant.output );



    }

}