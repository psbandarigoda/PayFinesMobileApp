package com.example.payfines.model;

import java.util.ArrayList;
import java.util.Date;

public class FinesDetails {

    private String dl;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String location;
    private String officerId;
    private ArrayList rule;
    private Integer total;
    private Date dateTime;
    private String status;

    public FinesDetails() {
    }

    public FinesDetails(String dl, String name, String email, String contact, String address, String location, String officerId, ArrayList rule, Integer total, Date dateTime, String status) {
        this.dl = dl;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.location = location;
        this.officerId = officerId;
        this.rule = rule;
        this.total = total;
        this.dateTime = dateTime;
        this.status = status;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public ArrayList getRule() {
        return rule;
    }

    public void setRule(ArrayList rule) {
        this.rule = rule;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
