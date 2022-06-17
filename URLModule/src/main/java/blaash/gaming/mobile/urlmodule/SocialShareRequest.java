package blaash.gaming.mobile.urlmodule;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SocialShareRequest {
    public String SharedAt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
    public Product ProductInformation;
}
