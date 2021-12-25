package com.example.model;

import java.io.Serializable;

public class Sale_Item implements Serializable {
    private int productThumb;
    private double productPrice;
    private String productName;

    public Sale_Item(double productPrice, int productThumb, String productName)
    {
        this.productName= productName;
        this.productThumb= productThumb;
        this.productPrice= productPrice;
    }
    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
    }

    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
