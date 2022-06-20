package blaash.gaming.mobile.urlmodule;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class EventProcessor {

    private static JsonObject returnJsonObject(Object obj)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = builder.setPrettyPrinting().create();
        String jsonString = gson.toJson(obj);

        return (JsonObject) JsonParser.parseString(jsonString);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected static Event_information eventDataFormatter(String event_name, Product cartProduct, String cartGrossTotal, String quantityAddedOrRemoved)
    {
        AddToCart addToCart = new AddToCart(cartGrossTotal,quantityAddedOrRemoved,cartProduct);
        return new Event_information(event_name,returnJsonObject(addToCart));
    }

    protected static Event_information eventDataFormatter(Customer customer)
    {
        return new Event_information(Constants.SIGN_UP,returnJsonObject(customer));
    }

    protected static Event_information eventDataFormatter(ProductReviewRequest reviewRequest)
    {
        return new Event_information(Constants.REVIEW,returnJsonObject(reviewRequest));
    }

    protected static Event_information eventDataFormatter(Product product)
    {
        return new Event_information(Constants.WISH_LIST,returnJsonObject(product));
    }

    protected static Event_information eventDataFormatter(ProductSearchRequest searchRequest)
    {
        return new Event_information(Constants.SEARCH,returnJsonObject(searchRequest));
    }

    protected static Event_information eventDataFormatter(ProductViewRequest productViewRequest)
    {
        return new Event_information(Constants.PRODUCT_VIEW,returnJsonObject(productViewRequest));
    }

    protected static Event_information eventDataFormatter(CustomerOrder customerOrder)
    {
        return new Event_information(Constants.CREATE_ORDER,returnJsonObject(customerOrder));
    }
}
