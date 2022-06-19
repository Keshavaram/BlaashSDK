package blaash.gaming.mobile.urlmodule;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import org.json.JSONException;
import com.google.gson.JsonObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BackGroundThread extends AsyncTask<Void,Void,EventInfo> {
    private static final String TAG = "BackGroundThread";
    private final OnBackGroundThreadComplete backGroundThreadComplete;
    private final Product product;
    private final String cartGrossTotal;
    private final String quantityAddedOrRemoved;
    private final boolean isCartAdded;

    public BackGroundThread(boolean isCartAdded,Product product, String cartGrossTotal, String quantityAddedOrRemoved, OnBackGroundThreadComplete backGroundThreadComplete) {
        this.product = product;
        this.cartGrossTotal = cartGrossTotal;
        this.quantityAddedOrRemoved = quantityAddedOrRemoved;
        this.backGroundThreadComplete = backGroundThreadComplete;
        this.isCartAdded = isCartAdded;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected EventInfo doInBackground(Void... notUsed) {
        AddToCart addToCart = new AddToCart(cartGrossTotal,quantityAddedOrRemoved,product);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonString = gson.toJson(addToCart);
        JsonParser jsonParser = new JsonParser();
        JsonObject json = (JsonObject) jsonParser.parse(jsonString);

//        try {
//            json = new JsonObject(jsonString);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        return new EventInfo(isCartAdded ? Constants.ADD_TO_CART : Constants.REMOVE_FROM_CART,json);
    }

    @Override
    protected void onPostExecute(EventInfo eventInfo) {
        backGroundThreadComplete.notify(eventInfo);
    }
}
