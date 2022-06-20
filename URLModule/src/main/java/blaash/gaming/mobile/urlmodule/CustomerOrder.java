package blaash.gaming.mobile.urlmodule;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CustomerOrder {
    public String orderId;
    public float orderGrandTotal;
    public float orderSubTotal;
    public float orderShippingAmount;
    public float orderDiscountAmount;
    public float orderTaxAmount;
    public String couponCodeUsed;
    public String storeName;
    public String storeCode;
    public String orderStatus;

    public  Address ShippingAddress;

    public  Address BillingAddress;
    public String orderCreatedAt = Instant.now().toString();
    public List<Product> orderProductInformation;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public float getOrderGrandTotal() {
        return orderGrandTotal;
    }

    public void setOrderGrandTotal(float orderGrandTotal) {
        this.orderGrandTotal = orderGrandTotal;
    }

    public float getOrderSubTotal() {
        return orderSubTotal;
    }

    public void setOrderSubTotal(float orderSubTotal) {
        this.orderSubTotal = orderSubTotal;
    }

    public float getOrderShippingAmount() {
        return orderShippingAmount;
    }

    public void setOrderShippingAmount(float orderShippingAmount) {
        this.orderShippingAmount = orderShippingAmount;
    }

    public float getOrderDiscountAmount() {
        return orderDiscountAmount;
    }

    public void setOrderDiscountAmount(float orderDiscountAmount) {
        this.orderDiscountAmount = orderDiscountAmount;
    }

    public float getOrderTaxAmount() {
        return orderTaxAmount;
    }

    public void setOrderTaxAmount(float orderTaxAmount) {
        this.orderTaxAmount = orderTaxAmount;
    }

    public String getCouponCodeUsed() {
        return couponCodeUsed;
    }

    public void setCouponCodeUsed(String couponCodeUsed) {
        this.couponCodeUsed = couponCodeUsed;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Address getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        BillingAddress = billingAddress;
    }

    public String getOrderCreatedAt() {
        return orderCreatedAt;
    }

    public void setOrderCreatedAt(String orderCreatedAt) {
        this.orderCreatedAt = orderCreatedAt;
    }

    public List<Product> getOrderProductInformation() {
        return orderProductInformation;
    }

    public void setOrderProductInformation(List<Product> orderProductInformation) {
        this.orderProductInformation = orderProductInformation;
    }
}
