package com.example.model;

public class Store {
    private String txtStoreName, txtAddress, txtDistance;

    public Store(String txtStoreName, String txtAddress, String txtDistance) {
        this.txtStoreName = txtStoreName;
        this.txtAddress = txtAddress;
        this.txtDistance = txtDistance;
    }

    public String getTxtStoreName() {
        return txtStoreName;
    }

    public void setTxtStoreName(String txtStoreName) {
        this.txtStoreName = txtStoreName;
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(String txtAddress) {
        this.txtAddress = txtAddress;
    }

    public String getTxtDistance() {
        return txtDistance;
    }

    public void setTxtDistance(String txtDistance) {
        this.txtDistance = txtDistance;
    }
}
