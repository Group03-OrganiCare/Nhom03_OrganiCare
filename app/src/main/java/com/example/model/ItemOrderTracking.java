package com.example.model;

public class ItemOrderTracking {
    private int productOrderThumb;
    private String productName;
    private double productPrice;
    private String productQuantity;
    private String DeliveryCondition;

    public ItemOrderTracking(int productOrderThumb, String productName, double productPrice, String productQuantity, String deliveryCondition) {
        this.productOrderThumb = productOrderThumb;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.DeliveryCondition = deliveryCondition;
    }

    public int getProductOrderThumb() {
        return productOrderThumb;
    }

    public void setProductOrderThumb(int productOrderThumb) {
        this.productOrderThumb = productOrderThumb;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getDeliveryCondition() {
        return DeliveryCondition;
    }

    public void setDeliveryCondition(String deliveryCondition) {
        this.DeliveryCondition = deliveryCondition;
    }
}
