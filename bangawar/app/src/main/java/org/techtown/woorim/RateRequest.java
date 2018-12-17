package org.techtown.woorim;

import android.content.ContentValues;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RateRequest extends StringRequest {

    final static private String URL = "http://woorim1022.cafe24.com/RateAverage.php";

    final ContentValues rateAverage = new ContentValues();


    public RateRequest(Float placeID, Float rate, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        rateAverage.put("placeID", placeID);
        rateAverage.put("rate", rate);
    }


}
