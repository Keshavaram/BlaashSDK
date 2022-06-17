package blaash.gaming.mobile.urlmodule;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;

public class TokenFormat {
    private final String created_on_timestamp;
    private final String Portal_CustomerId;
    private final String emailId;
    private final String facebookId;
    private final String clientId = BuildConfig.CLIENT_ID;
    private final String first_name;
    private final String last_name;
    private final String isAnonymous;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public TokenFormat(@NonNull String first_name, @NonNull String last_name, @NonNull String Portal_CustomerId, @NonNull String emailId, @NonNull String facebookId) {
        this.created_on_timestamp = String.valueOf(System.currentTimeMillis() / 1000);

        if (Portal_CustomerId.length() == 0 || emailId.length() == 0)
        {
            this.Portal_CustomerId = created_on_timestamp;
            this.emailId = created_on_timestamp + "@dummyemail.com";
            this.facebookId = "";
            this.first_name = "";
            this.last_name = "";
            this.isAnonymous = "true";
        } else
        {
            this.Portal_CustomerId = Portal_CustomerId;
            this.emailId = emailId;
            this.facebookId = facebookId;
            this.first_name = first_name;
            this.last_name = last_name;
            this.isAnonymous = "false";
        }
    }
}
