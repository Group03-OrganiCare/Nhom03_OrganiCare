package com.example.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String Name;
    private String District;
    private String Ward;
    private String Address;
    private String Email;
    private String Phone;

    public UserInfo(String name, String district, String ward, String address, String email, String phone) {
        Name = name;
        District = district;
        Ward = ward;
        Address = address;
        Email = email;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getWard() {
        return Ward;
    }

    public void setWard(String ward) {
        Ward = ward;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
