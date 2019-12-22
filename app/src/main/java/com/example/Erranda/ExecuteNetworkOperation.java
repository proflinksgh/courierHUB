package com.example.Erranda;

import android.os.AsyncTask;
import android.util.Log;

public class ExecuteNetworkOperation extends AsyncTask<Void, Void, String> {


    public ExecuteNetworkOperation(ApiAuthenticationClient apiAuthenticationClient) {
        this.apiAuthenticationClient = apiAuthenticationClient;
    }

    private ApiAuthenticationClient apiAuthenticationClient;
    protected String isValidCredentials;

    public ExecuteNetworkOperation() {
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        //progressbar.setVisibility( View.VISIBLE );

        Log.d("output", "Executed 1 ");
    }


    @Override
    protected String doInBackground(Void... params) {
        try{
            isValidCredentials = apiAuthenticationClient.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result){
        Log.d("output", "Result from API1 "+ result);

        Log.d("output", "Executed 2 ");
    }
}
