package com.example.model;

public class ItemSuggestion {
    private int ItemThumb;
    private String ItemName;


    public ItemSuggestion(int itemThumb, String itemName) {
        ItemThumb = itemThumb;
        ItemName = itemName;
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

}
