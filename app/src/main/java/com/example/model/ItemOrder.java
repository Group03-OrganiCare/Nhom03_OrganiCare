package com.example.model;

public class ItemOrder {
    private int ItemThumb;
    private String ItemName;
    private double ItemPrice;
    private double ItemWeight;
    private double ItemTotal;

    public ItemOrder(int itemThumb, String itemName, double itemPrice, double itemWeight, double itemTotal) {
        ItemThumb = itemThumb;
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemWeight = itemWeight;
        ItemTotal = itemTotal;
    }

    public int getItemThumb() {
        return ItemThumb;
    }

    public void setItemThumb(int itemThumb) {
        ItemThumb = itemThumb;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public double getItemWeight() {
        return ItemWeight;
    }

    public void setItemWeight(double itemWeight) {
        ItemWeight = itemWeight;
    }

    public double getItemTotal() {
        return ItemTotal;
    }

    public void setItemTotal(double itemTotal) {
        ItemTotal = itemTotal;
    }
}
