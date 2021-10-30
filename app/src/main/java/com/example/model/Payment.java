package com.example.model;

public class Payment {
    private int paymentThumb;
    private String paymentName;

    public Payment(int paymentThumb, String paymentName) {
        this.paymentThumb = paymentThumb;
        this.paymentName = paymentName;
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
