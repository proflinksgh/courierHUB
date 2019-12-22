package com.example.Erranda;

import com.google.gson.JsonParser;

/**
 * Created by mustafaferhan on 22/05/15.
 *
 * When the working on webview.evaluateJavascript() method, it return as String on onReceiveValue() method.
 * The problem is this String not convertable for JSON Object.
 * Error Log:
 * org.json.JSONException: Expected literal value at character 1 of  or
 * JSONException: Value of type java.lang.String cannot be converted to JSONObject
 *
 * Gson method is simple and clear.
 *
 */
public class StringUtil {

    String getAsString (String param){
        JsonParser parser = new JsonParser();
        String retVal = parser.parse(param).getAsString();
        return retVal;
    }
}
