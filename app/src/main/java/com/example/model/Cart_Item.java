package com.example.model;

public class Cart_Item {
    private int pickedThumb;
    private String pickedPrice;
    private String pickedName;
    private String pickedWeight;
    public Cart_Item(int pickedThumb, String pickedName, String pickedPrice, String pickedWeight)
    {
        this.pickedName= pickedName;
        this.pickedThumb= pickedThumb;
        this.pickedPrice= pickedPrice;
        this.pickedWeight = pickedWeight;
    }

    public int getPickedThumb() {
        return pickedThumb;
    }

    public void setPickedThumb(int pickedThumb) {
        this.pickedThumb = pickedThumb;
    }

    public String getPickedPrice() {
        return pickedPrice;
    }

    public void setPickedPrice(String pickedPrice) {
        this.pickedPrice = pickedPrice;
    }

    public String getPickedName() {
        return pickedName;
    }

    public void setPickedName(String pickedName) {
        this.pickedName = pickedName;
    }

    public String getPickedWeight() {
        return pickedWeight;
    }

    public void setPickedWeight(String pickedWeight) {
        this.pickedWeight = pickedWeight;
    }

}
