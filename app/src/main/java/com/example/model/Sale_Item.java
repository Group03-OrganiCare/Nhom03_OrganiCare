package com.example.model;

public class Sale_Item {
    private int productThumb;
    private String productPrice;
    private String productName;
    public Sale_Item(String productPrice, int productThumb, String productName)
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

    public String getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
