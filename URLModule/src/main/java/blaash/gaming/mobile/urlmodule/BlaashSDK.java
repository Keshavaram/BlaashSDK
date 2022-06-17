package blaash.gaming.mobile.urlmodule;

public class BlaashSDK implements OnBackGroundThreadComplete {
    private static final String TAG = "BlaashEvents";
    private String Portal_CustomerId;
    private String emailId;
    private String primaryPhoneNumber;
    private String first_name;
    private String last_name;
    private EventInfo eventInfo;
    CartProcessor cartProcessor = new CartProcessor();

    public BlaashSDK() {}

    public void initialize(String portal_CustomerId, String emailId, String primaryPhoneNumber,
                           String first_name, String last_name) {
        Portal_CustomerId = portal_CustomerId;
        this.emailId = emailId;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void notifyCartChanges(boolean isCartAdded,Product cartProduct,float cartGrossTotal,int quantityAddedOrRemoved)
    {
        cartProcessor.requestFormatter(isCartAdded, cartProduct, cartGrossTotal, quantityAddedOrRemoved,this);
    }

    @Override
    public void notify(EventInfo res) {
        eventInfo = res;
        BlaashEvents blaashEvents = cartProcessor.FormMessageRequest(Portal_CustomerId,emailId,primaryPhoneNumber,first_name,last_name,eventInfo);
        cartProcessor.dispatch(blaashEvents);
    }
}
