
/* Background AsynTask that Interfaces Java and PHP Scripts
All Class with Queries Extends this Class

*/

package com.example.Erranda;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Async extends android.os.AsyncTask<String, Void, String> {


    String url_link, post_data;
    String check;

    @Override
    protected void onPreExecute() {

        Log.d( "CREATION", "Execution is done2" );


    }

    @Override
    protected String doInBackground(String... params) {
        try {

            URL url = new URL( url_link );
            HttpURLConnection httpURLConnection = ( HttpURLConnection ) url.openConnection();
            httpURLConnection.setRequestMethod( "POST" );
            httpURLConnection.setDoOutput( true );
            httpURLConnection.setDoInput( true );
            OutputStream outputStream = httpURLConnection.getOutputStream();

            BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter( outputStream, "UTF-8" ) );


            bufferedWriter.write( post_data ); // Always instantiate
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream, "iso-8859-1" ) );

            StringBuilder stringBuilder = new StringBuilder();

            String data = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                data += line;


                //Output of Query  is saved in a Global variable 'Constant.data'
                Constant.data = data;
                Log.d("CREATION", "Date Retrieved "+data);
                Log.d("CREATION", "Username is "+ Constant.username);
            }

            bufferedWriter.close();
            outputStream.close();

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate( values );
    }

    @Override
    protected void onPostExecute(String result) {
    }
}

