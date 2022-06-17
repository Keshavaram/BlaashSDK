package blaash.gaming.mobile.urlmodule;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class InitiateHttpPost {
    private static final String TAG = "InitiateHttpPost";
    private final Object body;
    private final CartProcessor context;

    protected InitiateHttpPost(Object body, CartProcessor context) {
        this.body = body;
        this.context = context;
    }

    public void initiatePostRequest()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.setPrettyPrinting().create();
        String jsonBody = gson.toJson(this.body);
        Log.e(TAG, "initiateReview1: Json that is being sent : " + jsonBody);
        PostHttpRequest post = new PostHttpRequest(this.context);
        post.execute(Constants.TEST_URL,jsonBody);
    }
}