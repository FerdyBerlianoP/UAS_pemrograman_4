package com.nyoba.uas.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMinuman {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Minuman> listDataMinuman;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Minuman> getListDataMinuman() {
        return listDataMinuman;
    }
    public void setListDataMinuman(List<Minuman> listDataMinuman) {
        this.listDataMinuman = listDataMinuman;
    }
}