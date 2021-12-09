package com.example.model;

public class ItemSimilar {
    private int ItemThumb;
    private String ItemName;
    private double ItemPrice;

    public ItemSimilar(int itemThumb, String itemName, double itemPrice) {
        ItemThumb = itemThumb;
        ItemName = itemName;
        ItemPrice = itemPrice;
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
}
