//package com.example.Erranda;
//
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.text.TextUtils;
//import android.util.Log;
//
//import com.android.volley.toolbox.HttpResponse;
//import com.squareup.okhttp.Headers;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;
//
//import java.net.URI;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import androidx.annotation.Nullable;
//import okhttp3.MediaType;
//import okhttp3.RequestBody;
//
//public class ParseController {
//
//    private Map<String, String> map;
//    private Activity activity;
//    private AsyncTaskCompleteListener listener;
//    private String url = Constant.URL,
//            loadingMsg;
//    private boolean isShowLoading;
//    private HttpMethod httpMethod;
//    private int statusCode;
//    private UserPreference pref;
//    private boolean firstCalling = true, hasFiveSecsPassed=false;
//    private AsyncHttpRequest myAsyncHttpRequest;
//    ProgressDialog pdialog;
//
//    public enum HttpMethod {
//        GET,
//        POST,
//        PUT,
//        DELETE,
//        HEAD,
//        CONNECT,
//        OPTIONS,
//        TRACE,
//        PATCH,
//        MERGE
//    }
//
//    public interface AsyncTaskCompleteListener {
//        void onSuccess(String response);
//
//        void onFailed(String msg);
//    }
//
//    // ParseController constructor,get all parameter via map,checking internet
//    // connection
//    public ParseController(Activity act, HttpMethod method,
//                           Map<String, String> map, boolean isShowLoading, String loadingMsg,
//                           AsyncTaskCompleteListener listener) {
//
//        this.map = map;
//        this.httpMethod = method;
//        this.activity = act;
//        this.listener = listener;
//        this.loadingMsg = loadingMsg;
//        this.isShowLoading = isShowLoading;
//        this.pref = new UserPreference(activity);
//        // is Internet Connection Available...
////        if (Utils.isNetworkAvailable(activity)) {
////            if (map.containsKey("url")) {
////                url = map.get("url");
////                map.remove("url");
////            }
//            pdialog = new ProgressDialog(activity);
//            myAsyncHttpRequest =  new AsyncHttpRequest();
//            myAsyncHttpRequest.execute();
//          /*  if(httpMethod.toString().equalsIgnoreCase("GET")){
//                timerHandler.postDelayed(timerRunnable, 5000);
//            }*/
////        } else {
////            listener.onFailed(act.getResources().getString(R.string.interneterror));
////        }
//    }
//
//
//    //runs without a timer by reposting this handler at the end of the runnable
//  /*  Handler timerHandler = new Handler();
//    Runnable timerRunnable = new Runnable() {
//
//        @Override
//        public void run() {
//          //  timerHandler.postDelayed(this, 1000);
//            myAsyncHttpRequest.cancel(true);
//            hasFiveSecsPassed=true;
//            Log.w("Timer", String.valueOf(hasFiveSecsPassed) );
//            pdialog.dismiss();
//            myAsyncHttpRequest =   new AsyncHttpRequest();
//            myAsyncHttpRequest.execute();
//        }
//    };*/
//
//    // API call via async Task
//    class AsyncHttpRequest extends AsyncTask<Void, Void, String> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            if (!activity.isFinishing() && isShowLoading) {
//                pdialog.setCancelable(false);
//                pdialog.setMessage(loadingMsg);
//                pdialog.show();
//            }
//        }
//
//        @Override
//        protected String doInBackground(Void... params) {
//            return chooseWebService();
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//
//            if (pdialog != null && pdialog.isShowing()) {
//                pdialog.dismiss();
//            }
//            //  timerHandler.removeCallbacks(timerRunnable);
//            checkResponse(result);
//            super.onPostExecute(result);
//        }
//    }
//
//    @Nullable
//    private String chooseWebService() {
//        switch (httpMethod) {
//            case POST:
//                return callNewPOSTWebService(); //callPOSTWebService();
//            case GET:
//                return callNewGETWebService(); //callGETWebService();
//            case DELETE:
//                return callNewDELETEWebService(); //callDELETEWebService();
//            case PUT:
//                return callNewPUTWebService(); //callPUTWebService();
//            default:
//                return null;
//        }
//       /* }else {
//            timerHandler.removeCallbacks(timerRunnable);
//            Log.w("Timer", "i ran" );
//            return null;
//        }*/
//    }
//
//    // NEW GET Call
//    @Nullable
//    private String callNewGETWebService(){
//
//        Log.v("========", "=================================================================\n");
//        Log.e("url",url);
//
//        try {
//            OkHttpClient client;
//            Headers.Builder headers = new Headers.Builder();
//
//            if (map.containsKey("loginbase64")) {
//                headers.add("Authorization",map.get("loginbase64"));
//            } else {
//                headers.add("Authorization",pref.getBase64string());
//            }
//
//            headers.add( "Content-Type", "text/plain");;
//            headers.add( "Accept", "application/json ");
//            //   headers.add("x-location", pref.strGetLocation());
//            // headers.add("x-device-info", pref.getDeviceInfo());
//
//            headers.add("x-location", "north");
//            headers.add("x-device-info", "moto");
//
//
//            Headers head = headers.build();
//            Request request = new Request.Builder()
//                    .url(url)
//                    .headers(head)
//                    .build();
//            client = new OkHttpClient.Builder()
//                    .connectTimeout(180, TimeUnit.SECONDS)
//                    .readTimeout(180, TimeUnit.SECONDS)
//                    .writeTimeout(180, TimeUnit.SECONDS)
//                    .build();
//            Response response = client.newCall(request).execute();
//            statusCode = response.code();
//            //  Log.w("Response", response.toString());
//            return response.body().string();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return  null;
//    }
////    // GET CALL
////    private String callGETWebService() {
////        try {
////            List<NameValuePair> params = new LinkedList<NameValuePair>();
////
////            for (String key : map.keySet()) {
////                params.add(new BasicNameValuePair(key, map.get(key)));
////            }
////
////            HttpGet httpGet = null;
////            if (!map.containsKey("loginbase64")) {
////                String paramString = URLEncodedUtils.format(params, "utf-8");
////                url += paramString;
////                String encodeUrl = URLDecoder.decode(url, "utf-8");
////
////                URL url1 = new URL(encodeUrl);
////                URI uri = new URI(url1.getProtocol(), url1.getHost(),
////                        url1.getPath(), url1.getQuery(), null);
////
////                String finalUrl = uri.toString();
////
////                if (finalUrl.contains("%20") && finalUrl.contains("phone_number")) {
////                    finalUrl = finalUrl.replaceAll("%20", "%2B");
////
////                    httpGet = new HttpGet(finalUrl);
////                } else {
////                    httpGet = new HttpGet(finalUrl);
////                }
////
////                Log.v("========", "=================================================================");
////                System.out.println();
////                Log.e("url",finalUrl);
////                System.out.println();
////
////            } else {
////                String encodeUrl = URLDecoder.decode(url, "utf-8");
////
////                URL url1 = new URL(encodeUrl);
////                URI uri = new URI(url1.getProtocol(), url1.getHost(),
////                        url1.getPath(), url1.getQuery(), null);
////                String finalUrl = uri.toString();
////                httpGet = new HttpGet(finalUrl);
////            }
////
////
////            HttpClient client = new DefaultHttpClient();
////
////
////            if (map.containsKey("loginbase64")) {
////                httpGet.addHeader("Authorization", map.get("loginbase64"));
////            } else {
////                httpGet.addHeader("Authorization", pref.getBase64string());
////            }
////
////            httpGet.setHeader("Content-Type", Constant.CONTENT_TYPE);
////            httpGet.setHeader("Accept", Constant.CONTENT_TYPE);
////            // httpGet.setHeader("x-location", pref.strGetLocation());
////            httpGet.setHeader("x-location", "north");
////            //  httpGet.setHeader("x-device-info", pref.getDeviceInfo());
////            httpGet.setHeader("x-device-info", "moto");
////
////
////
////
////            HttpResponse httpResponse = client.execute(httpGet);
////            statusCode = httpResponse.getStatusLine().getStatusCode();
////            HttpEntity resEntityGet = httpResponse.getEntity();
////            if (resEntityGet != null) {
////                //  String response = EntityUtils.toString(resEntityGet);
////                return Utils.convertStreamtoString(resEntityGet);
////                //  return response;
////            }
////        } catch (UnknownHostException e) {
////            return "UnknownHostException";
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return null;
////    }
//
//    // NEW POST CALL
//    @Nullable
//    private String callNewPOSTWebService(){
//        Log.v("========", "=================================================================\n");
//        Log.e("url",url);
//
//        Log.e("JSON", map.get("body"));
//        try {
//            OkHttpClient client;
//            Headers.Builder headers = new Headers.Builder();
//
//            headers.add("Authorization",pref.getBase64string());
//            headers.add("Content-Type", "text/plain");
//            headers.add("Accept", Constant.CONTENT_TYPE);
////            headers.add("x-location", pref.strGetLocation());
////            headers.add("x-device-info", pref.getDeviceInfo());
//
//            headers.add("x-location", "north");
//            headers.add("x-device-info", "moto");
//
//
//            MediaType mediaType = MediaType.parse(Constant.CONTENT_TYPE);
//            RequestBody requestBody1 = RequestBody.create(mediaType, map.get("body"));
//            /*final RequestBody requestBody = new RequestBody() {
//                @Override
//                public MediaType contentType() {
//                    return null;
//                }
//
//                @Override
//                public void writeTo(BufferedSink sink) throws IOException {
//
//                }
//            };*/
//
//            Headers head = headers.build();
//            Request request = new Request.Builder()
//                    .url(url)
//                    .post(requestBody1)
//                    .headers(head)
//                    .build();
//
//            client = new OkHttpClient.Builder()
//                    .connectTimeout(180, TimeUnit.SECONDS)
//                    .readTimeout(180, TimeUnit.SECONDS)
//                    .writeTimeout(180, TimeUnit.SECONDS)
//                    .build();
//            Response response = client.newCall(request).execute();
//
//            statusCode = response.code();
//            //  Log.w("Response", response.toString());
//
//            return response.body().string();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return  null;
//    }
//    // POST CALL
//    private String callPOSTWebService() {
//        try {
//            Log.e("=============", "=================================================================");
//            System.out.println();
//            Log.e("url", url);
//            System.out.println();
//            HttpPost httpPost = new HttpPost(url);
//
//            if (map != null && map.size() > 0) {
//                if (map.containsKey("body")) {
//                    StringEntity se = new StringEntity(map.get("body"));
//                    Log.e("JSON", map.get("body"));
//                    httpPost.setEntity(se);
//                } else {
//                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                    for (String key : map.keySet()) {
//
//                        nameValuePairs
//                                .add(new BasicNameValuePair(key, map.get(key)));
//                        Log.e("params", key + "=" + map.get(key));
//                        System.out.println();
//                    }
//                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                }
//            }
//
//
//            HttpClient client = new DefaultHttpClient();
//
//            httpPost.addHeader("Authorization", pref.getBase64string());
//            httpPost.setHeader("Content-Type", Constant.CONTENT_TYPE);
//            httpPost.setHeader("Accept", Constant.CONTENT_TYPE);
//            // httpPost.setHeader("x-location", pref.strGetLocation());
//            //   httpPost.setHeader("x-device-info", pref.getDeviceInfo());
//
//            httpPost.setHeader("x-location", "north");
//            httpPost.setHeader("x-device-info", "moto");
//
//
//            HttpResponse httpResponse = client.execute(httpPost);
//            statusCode = httpResponse.getStatusLine().getStatusCode();
//            HttpEntity entity = httpResponse.getEntity();
//            Log.e("RSES", statusCode + "");
//            String response = EntityUtils.toString(entity);
//            return response;
//
//        } catch (UnknownHostException e) {
//            return "UnknownHostException";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    // NEW DELETE CALL
//    @Nullable
//    private String callNewDELETEWebService(){
//        Log.v("========", "=================================================================\n");
//        Log.e("url",url);
//
//        Log.e("JSON", map.get("body"));
//        try {
//            OkHttpClient client;
//            Headers.Builder headers = new Headers.Builder();
//
//            headers.add("Authorization",pref.getBase64string());
//            headers.add("Content-Type", Constant.CONTENT_TYPE);
//            headers.add("Accept", Constant.CONTENT_TYPE);
////            headers.add("x-location", pref.strGetLocation());
////            headers.add("x-device-info", pref.getDeviceInfo());
//
//            headers.add("x-location", "north");
//            headers.add("x-device-info", "moto");
//
//
//            MediaType mediaType = MediaType.parse(Constant.CONTENT_TYPE);
//            RequestBody requestBody1 = RequestBody.create(mediaType, map.get("body"));
//
//            Headers head = headers.build();
//            Request request = new Request.Builder()
//                    .url(url)
//                    .delete(requestBody1)
//                    .headers(head)
//                    .build();
//
//            client = new OkHttpClient.Builder()
//                    .connectTimeout(60, TimeUnit.SECONDS)
//                    .readTimeout(60, TimeUnit.SECONDS)
//                    .writeTimeout(60, TimeUnit.SECONDS)
//                    .build();
//            Response response = client.newCall(request).execute();
//
//            statusCode = response.code();
//            //  Log.w("Response", response.toString());
//
//            return response.body().string();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return  null;
//    }
//    // DELETE CALL
//    private String callDELETEWebService() {
//
//        class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
//            public static final String METHOD_NAME = "DELETE";
//            public String getMethod() { return METHOD_NAME; }
//
//            public HttpDeleteWithBody(final String uri) {
//                super();
//                setURI(URI.create(uri));
//            }
//          /*  public HttpDeleteWithBody(final URI uri) {
//                super();
//                setURI(uri);
//            }
//            public HttpDeleteWithBody() { super(); } */
//        }
//        try {
//            HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(url);
//            Log.e("===============", "=================================================================");
//            System.out.println();
//            Log.e("url", url);
//            System.out.println();
//
//
//            if (map != null && map.size()>0) {
//                if(map.containsKey("body")){
//                    StringEntity se = new StringEntity(map.get("body"));
//                    Log.e("JSON", map.get("body"));
//                    httpDelete.setEntity(se);
//                }else{
//                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                    for (String key : map.keySet()) {
//                        nameValuePairs.add(new BasicNameValuePair(key, map.get(key)));
//                        Log.e("params", key + "=" + map.get(key));
//                    }
//
//                    httpDelete.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                }
//
//            }
//
//
//            HttpClient client = new DefaultHttpClient();
//            httpDelete.setHeader("Authorization",pref.getBase64string());
//            httpDelete.setHeader("Content-Type", Constant.CONTENT_TYPE);
//            httpDelete.setHeader("Accept", Constant.CONTENT_TYPE);
////            httpDelete.setHeader("x-location", pref.strGetLocation());
////            httpDelete.setHeader("x-device-info", pref.getDeviceInfo());
//
//            httpDelete.setHeader("x-location", "north");
//            httpDelete.setHeader("x-device-info", "moto");
//
//
//            HttpResponse httpResponse = client.execute(httpDelete);
//            HttpEntity entity = httpResponse.getEntity();
//            statusCode = httpResponse.getStatusLine().getStatusCode();
//
//            String response = EntityUtils.toString(entity);
//            return response;
//
//        } catch (UnknownHostException e) {
//            return "UnknownHostException";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    // NEW PUT CALL
//    @Nullable
//    private String callNewPUTWebService(){
//        Log.v("========", "=================================================================\n");
//        Log.e("url",url);
//
//        Log.e("JSON", map.get("body"));
//        try {
//            OkHttpClient client;
//            Headers.Builder headers = new Headers.Builder();
//
//            headers.add("Authorization",pref.getBase64string());
//            headers.add("Content-Type", Constant.CONTENT_TYPE);
//            headers.add("Accept", Constant.CONTENT_TYPE);
////            headers.add("x-location", pref.strGetLocation());
////            headers.add("x-device-info", pref.getDeviceInfo());
//
//            headers.add("x-location", "north");
//            headers.add("x-device-info", "moto");
//
//
//            MediaType mediaType = MediaType.parse(Constant.CONTENT_TYPE);
//            RequestBody requestBody1 = RequestBody.create(mediaType, map.get("body"));
//
//            Headers head = headers.build();
//            Request request = new Request.Builder()
//                    .url(url)
//                    .put(requestBody1)
//                    .headers(head)
//                    .build();
//
//            client = new OkHttpClient.Builder()
//                    .connectTimeout(180, TimeUnit.SECONDS)
//                    .readTimeout(180, TimeUnit.SECONDS)
//                    .writeTimeout(180, TimeUnit.SECONDS)
//                    .build();
//            Response response = client.newCall(request).execute();
//
//            statusCode = response.code();
//            //  Log.w("Response", response.toString());
//
//            return response.body().string();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return  null;
//    }
//    // PUT CALL
//    private String callPUTWebService() {
//        try {
//            HttpPut httpPut = new HttpPut(url);
//            Log.e("===============", "=================================================================");
//            System.out.println();
//            Log.e("url", url);
//            System.out.println();
//
//            if (map != null && map.size() > 0) {
//                if (map.containsKey("body")) {
//                    StringEntity se = new StringEntity(map.get("body"));
//                    Log.e("JSON", map.get("body"));
//                    httpPut.setEntity(se);
//                } else {
//                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//                    for (String key : map.keySet()) {
//                        nameValuePairs
//                                .add(new BasicNameValuePair(key, map.get(key)));
//                        Log.e("params", key + "=" + map.get(key));
//                    }
//                    httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                }
//            }
//
//
//            HttpClient client = new DefaultHttpClient();
//
//            httpPut.addHeader("Authorization", pref.getBase64string());
//            httpPut.setHeader("Content-Type", Constant.CONTENT_TYPE);
//            httpPut.setHeader("Accept", Constant.CONTENT_TYPE);
////            httpPut.setHeader("x-location", pref.strGetLocation());
////            httpPut.setHeader("x-device-info", pref.getDeviceInfo());
//
//            httpPut.setHeader("x-location", "north");
//            httpPut.setHeader("x-device-info", "moto");
//
//
//
//            HttpResponse httpResponse = client.execute(httpPut);
//            HttpEntity entity = httpResponse.getEntity();
//            statusCode = httpResponse.getStatusLine().getStatusCode();
//            String response = EntityUtils.toString(entity);
//            return response;
//
//        } catch (UnknownHostException e) {
//            return "UnknownHostException";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    // checking response is null or empty if not null call onTaskCompleted
//    // method
//    public void checkResponse(String response) {
//
//        if (response == null || TextUtils.isEmpty(response.trim())
//                || response.trim().equalsIgnoreCase("null")) {
//            if (firstCalling && !httpMethod.name().equalsIgnoreCase("POST")){
//                //  Log.w("Timer", "i switched" );
//                firstCalling = false;
//                //hasFiveSecsPassed=false;
//                if(url.contains(pref.getURL())){
//                    url = url.replace(pref.getURL(), Constant.URL_BACKUP);
//                }else {
//                    url = url.replace(Constant.URL, Constant.URL_BACKUP);
//                }
//                new AsyncHttpRequest().execute();
//            }else {
//                listener.onFailed("Response is empty, Please Try Again Later");
//            }
//        } else if (response.equals("UnknownHostException")) {
//            listener.onFailed(activity.getResources().getString(R.string.interneterror));
//        } else if(statusCode!=200){
//            if (firstCalling){
//                firstCalling = false;
//                if(url.contains(pref.getURL())){
//                    url = url.replace(pref.getURL(), Constant.URL_BACKUP);
//                }else {
//                    url = url.replace(Constant.URL, Constant.URL_BACKUP);
//                }
//                // String strUrl = url.substring(url.lastIndexOf("/")+1);
//                // url = Constant.URL_BACKUP+strUrl;
//                new AsyncHttpRequest().execute();
//            }else {
//                listener.onFailed(response);
//            }
//        }else {
//            Log.e("Response in Controller", response.trim());
//            Log.e("=======", "=================================================================");
//            listener.onSuccess(response);
//        }
//    }
//
//}
//
