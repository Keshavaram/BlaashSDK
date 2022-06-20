package blaash.gaming.mobile.urlmodule;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ProductReviewRequest {
    public String reviewedAt = Instant.now().toString();
    public String reviewText;
    public Product productInformation;

    public ProductReviewRequest(String reviewText, Product productInformation) {
        this.reviewText = reviewText;
        this.productInformation = productInformation;
    }
}