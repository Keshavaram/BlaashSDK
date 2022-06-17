package blaash.gaming.mobile.urlmodule;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    public String first_name;
    public String last_name;
    public String emailId;
    public String facebookId;
    public String primaryPhoneNumber;
    public String customerCreatedStoreName;
    public String customerPrimaryNumber;
    public String customerIsdCode;
    public String customerCreatedAt;//TODO Review the format

    public String CustomerReferralCode;

    public Customer(String first_name, String last_name, String emailId,
                    String facebookId, String primaryPhoneNumber, String customerCreatedStoreName,
                    String customerPrimaryNumber, String customerIsdCode,
                    String customerReferralCode) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.emailId = emailId;
        this.facebookId = facebookId;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.customerCreatedStoreName = customerCreatedStoreName;
        this.customerPrimaryNumber = customerPrimaryNumber;
        this.customerIsdCode = customerIsdCode;
        this.customerCreatedAt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
        CustomerReferralCode = customerReferralCode;
    }
}
