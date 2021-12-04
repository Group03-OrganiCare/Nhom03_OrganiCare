package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ItemPayment {
    int paymentThumb;
    String paymentName;

    public ItemPayment(int paymentThumb, String paymentName) {
        this.paymentThumb = paymentThumb;
        this.paymentName = paymentName;
    }

    public ItemPayment() {
    }

    public int getPaymentThumb() {
        return paymentThumb;
    }

    public void setPaymentThumb(int paymentThumb) {
        this.paymentThumb = paymentThumb;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}