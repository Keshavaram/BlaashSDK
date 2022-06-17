package blaash.gaming.mobile.urlmodule;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BackGroundThread extends AsyncTask<Void,Void,EventInfo> {
    private static final String TAG = "BackGroundThread";
    private final OnBackGroundThreadComplete backGroundThreadComplete;
    private final Product product;
    private final float cartGrossTotal;
    private final int quantityAddedOrRemoved;
    private final boolean isCartAdded;

    public BackGroundThread(boolean isCartAdded,Product product, float cartGrossTotal, int quantityAddedOrRemoved, OnBackGroundThreadComplete backGroundThreadComplete) {
        this.product = product;
        this.cartGrossTotal = cartGrossTotal;
        this.quantityAddedOrRemoved = quantityAddedOrRemoved;
        this.backGroundThreadComplete = backGroundThreadComplete;
        this.isCartAdded = isCartAdded;
    }

    @Override
    protected EventInfo doInBackground(Void... notUsed) {
//        Map<String,String> fields = new HashMap<>();
//        for (Field field : product.getClass().getDeclaredFields()) {
//            try {
//                fields.put(field.getName(), Objects.requireNonNull(field.get(product)).toString());
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        for (String s :
//                fields.keySet()) {
//            try { json.put(s, fields.get(s));}
//            catch (JSONException e) { e.printStackTrace();}
//        }
//        try {
//            json.put("cartGrossTotal",cartGrossTotal);
//            json.put("quantityAddedOrRemoved",quantityAddedOrRemoved);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonString = gson.toJson(product);
        JSONObject json = null;
        try {
            json = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        JsonParser parser = new JsonParser();
//        json = (JSONObject)parser.parse(jsonString);

        return new EventInfo(isCartAdded ? Constants.ADD_TO_CART : Constants.REMOVE_FROM_CART,json);
    }

    @Override
    protected void onPostExecute(EventInfo eventInfo) {
        backGroundThreadComplete.notify(eventInfo);
    }
}
