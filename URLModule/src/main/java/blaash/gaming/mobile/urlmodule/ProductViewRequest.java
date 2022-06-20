package blaash.gaming.mobile.urlmodule;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ProductViewRequest {
    private final String viewedAt = Instant.now().toString();
    private final Product productInformation;

    public ProductViewRequest(Product productInformation) {
        this.productInformation = productInformation;
    }
}
