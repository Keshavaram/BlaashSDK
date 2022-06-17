package blaash.gaming.mobile.urlmodule;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductReviewRequest {
    public String reviewedAt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
    public String reviewText;
    public Product productInformation;

    public ProductReviewRequest(String reviewText, Product productInformation) {
        this.reviewText = reviewText;
        this.productInformation = productInformation;
    }
}