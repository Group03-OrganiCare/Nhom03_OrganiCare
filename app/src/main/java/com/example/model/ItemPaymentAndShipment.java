package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ItemPaymentAndShipment {
    int payAndShipThumb;
    String payAndShipName;
    Double payAndShipPrice;

    public ItemPaymentAndShipment() {
    }

    public ItemPaymentAndShipment(int payAndShipThumb, String payAndShipName, double payAndShipPrice) {
        this.payAndShipThumb = payAndShipThumb;
        this.payAndShipName = payAndShipName;
        this.payAndShipPrice = payAndShipPrice;
    }


    public int getPayAndShipThumb() {
        return payAndShipThumb;
    }

    public void setPayAndShipThumb(int payAndShipThumb) {
        this.payAndShipThumb = payAndShipThumb;
    }

    public String getPayAndShipName() {
        return payAndShipName;
    }

    public void setPayAndShipName(String payAndShipName) {
        this.payAndShipName = payAndShipName;
    }

    public double getPayAndShipPrice() {
        return payAndShipPrice;
    }

    public void setPayAndShipPrice(double payAndShipPrice) {
        this.payAndShipPrice = payAndShipPrice;
    }

}