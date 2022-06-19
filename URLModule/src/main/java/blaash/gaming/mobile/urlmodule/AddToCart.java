package blaash.gaming.mobile.urlmodule;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;

public class AddToCart {
    private String cartGrossTotal;
    private String quantityAdded;
    private Product productInformation;
    private String cartUpdatedOn;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public AddToCart(String cartGrossTotal, String quantityAdded, Product productInformation) {
        this.cartGrossTotal = cartGrossTotal;
        this.quantityAdded = quantityAdded;
        this.productInformation = productInformation;
        this.cartUpdatedOn = Instant.now().toString();
    }
}
