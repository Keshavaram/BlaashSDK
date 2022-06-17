package blaash.gaming.mobile.urlmodule;

import androidx.annotation.NonNull;

import java.util.List;

public class BlaashEvents {
    private static final String TAG = "BlaashEvents";
    private String Portal_CustomerId;
    private String emailId;
    private String primaryPhoneNumber;
    private String first_name;
    private String last_name;
    private List<EventInfo> event_info;

    public BlaashEvents(String portal_CustomerId, String emailId,
                        String primaryPhoneNumber, String first_name,
                        String last_name,List<EventInfo> event_info) {
        Portal_CustomerId = portal_CustomerId;
        this.emailId = emailId;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.first_name = first_name;
        this.last_name = last_name;
        this.event_info = event_info;
    }
    //blaashSdk
    //Intialize()

    //NotifyCartChanges(bool isCardAdded,Product cardProduct,decimal grossTotal,int qualityaddedRemoved)
   // {
        //n event_informmation CardProceessor.RequestFOrmatter()
        // blaash_eveny = FormMessageReqyest(event_informmation);
        //Dispatch(blaash_eveny);
   // }

    @NonNull
    @Override
    public String toString() {
        return "Customer ID = " + this.Portal_CustomerId + ",\n" +
                "Email ID = " + this.emailId + ",\n" +
                "First Name = " + this.first_name + ",\n" +
                "Primary Phone Number =  " + this.primaryPhoneNumber + ",\n" +
                "Last Name = " + this.last_name + ",\n" +
                "Event info = " + event_info;
    }
}
