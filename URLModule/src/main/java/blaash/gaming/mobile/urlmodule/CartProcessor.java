package blaash.gaming.mobile.urlmodule;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class CartProcessor implements OnHttpPostComplete{
    private static final String TAG = "CartProcessor";

    public CartProcessor() {}

    public void requestFormatter(boolean isCartAdded, Product cartProduct, float cartGrossTotal, int quantityAddedOrRemoved, BlaashSDK context)
    {
        BackGroundThread bgThread = new BackGroundThread(isCartAdded,cartProduct,cartGrossTotal,quantityAddedOrRemoved, context);
        bgThread.execute();
    }
    public BlaashEvents FormMessageRequest(String portal_CustomerId, String emailId, String primaryPhoneNumber,
                                           String first_name, String last_name,EventInfo eventInfo)
    {
        List<EventInfo> temp = new ArrayList<>();
        temp.add(eventInfo);
        return new BlaashEvents(portal_CustomerId, emailId, primaryPhoneNumber, first_name, last_name,temp);
    }
    public void dispatch(BlaashEvents dataToSend)
    {
        InitiateHttpPost initiateHttpPost = new InitiateHttpPost(dataToSend,this);
        initiateHttpPost.initiatePostRequest();
    }

    @Override
    public void notify(String s) {
        Log.e(TAG, "notify: " + s);
    }
}
