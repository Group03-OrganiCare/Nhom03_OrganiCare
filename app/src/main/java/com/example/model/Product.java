package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Serializable {
    private int ProductThumb;
    private String ProductName;
    private double ProductPrice;
    private String ProductCert1;
    private String ProductCert2;

    public Product(int productThumb, String productName, double productPrice, String productCert1, String productCert2) {
        ProductThumb = productThumb;
        ProductName = productName;
        ProductPrice = productPrice;
        ProductCert1 = productCert1;
        ProductCert2 = productCert2;
    }

    public int getProductThumb() {
        return ProductThumb;
    }

    public void setProductThumb(int productThumb) {
        ProductThumb = productThumb;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductCert1() {
        return ProductCert1;
    }

    public void setProductCert1(String productCert1) {
        ProductCert1 = productCert1;
    }

    public String getProductCert2() {
        return ProductCert2;
    }

    public void setProductCert2(String productCert2) {
        ProductCert2 = productCert2;
    }

}
