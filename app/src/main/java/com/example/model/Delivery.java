package com.example.model;



public class Delivery  {
    int deliveryThumb;
    double deliveryPrice;

    public Delivery() {
    }

    public Delivery(int deliveryThumb, double deliveryPrice) {
        this.deliveryThumb = deliveryThumb;
        this.deliveryPrice = deliveryPrice;
    }

    public int getDeliveryThumb() {
        return deliveryThumb;
    }

    public void setDeliveryThumb(int deliveryThumb) {
        this.deliveryThumb = deliveryThumb;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }
}
