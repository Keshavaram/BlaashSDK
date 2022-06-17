package blaash.gaming.mobile.urlmodule;

public class JsonToSend {
    private static final String TAG = "BlaashEvents";
    private String Portal_CustomerId;
    private String emailId;
    private String primaryPhoneNumber;
    private String first_name;
    private String last_name;
    private EventInfo event_info;

    public JsonToSend(String portal_CustomerId, String emailId, String primaryPhoneNumber,
                      String first_name, String last_name, EventInfo event_info) {
        Portal_CustomerId = portal_CustomerId;
        this.emailId = emailId;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.first_name = first_name;
        this.last_name = last_name;
        this.event_info = event_info;
    }
}
