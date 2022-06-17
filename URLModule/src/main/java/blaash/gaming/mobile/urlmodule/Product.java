package blaash.gaming.mobile.urlmodule;

public class Product {
    public String productSKU;

    public String productDisplayName;
    public String productShortName;
    public String productURL;
    public String baseImageURL;
    public String productPrice;
    public String productCategoryNames;
    public String productCategory;
    public String portalProductID;

    public Product(String productSKU, String productDisplayName, String productShortName, String productURL,
                   String baseImageURL, String productPrice, String productCategoryNames, String productCategory,
                   String portalProductID) {
        this.productSKU = productSKU;
        this.productDisplayName = productDisplayName;
        this.productShortName = productShortName;
        this.productURL = productURL;
        this.baseImageURL = baseImageURL;
        this.productPrice = productPrice;
        this.productCategoryNames = productCategoryNames;
        this.productCategory = productCategory;
        this.portalProductID = portalProductID;
    }
}
