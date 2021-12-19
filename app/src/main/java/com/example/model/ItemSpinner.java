package com.example.model;

public class ItemSpinner {
    private int ItemIcon;
    private String ItemName;

    public ItemSpinner(int itemIcon, String itemName) {
        ItemIcon = itemIcon;
        ItemName = itemName;
    }

    public int getItemIcon() {
        return ItemIcon;
    }

    public void setItemIcon(int itemId) {
        ItemIcon = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }
}
