package com.example.model;

public class Delivering {
    private int ProductThumb_delivering;
    private String ProductName_delivering;
    private int PriceEach_delivering, PriceInvoice_delivering;
    private double Weight_delivering;

    public Delivering(int productThumb_delivering, String productName_delivering, int priceEach_delivering, int priceInvoice_delivering, double weight_delivering) {
        ProductThumb_delivering = productThumb_delivering;
        ProductName_delivering = productName_delivering;
        PriceEach_delivering = priceEach_delivering;
        PriceInvoice_delivering = priceInvoice_delivering;
        Weight_delivering = weight_delivering;
    }

    public int getProductThumb_delivering() {
        return ProductThumb_delivering;
    }

    public void setProductThumb_delivering(int productThumb_delivering) {
        ProductThumb_delivering = productThumb_delivering;
    }

    public String getProductName_delivering() {
        return ProductName_delivering;
    }

    public void setProductName_delivering(String productName_delivering) {
        ProductName_delivering = productName_delivering;
    }

    public int getPriceEach_delivering() {
        return PriceEach_delivering;
    }

    public void setPriceEach_delivering(int priceEach_delivering) {
        PriceEach_delivering = priceEach_delivering;
    }

    public int getPriceInvoice_delivering() {
        return PriceInvoice_delivering;
    }

    public void setPriceInvoice_delivering(int priceInvoice_delivering) {
        PriceInvoice_delivering = priceInvoice_delivering;
    }

    public double getWeight_delivering() {
        return Weight_delivering;
    }

    public void setWeight_delivering(double weight_delivering) {
        Weight_delivering = weight_delivering;
    }
}
