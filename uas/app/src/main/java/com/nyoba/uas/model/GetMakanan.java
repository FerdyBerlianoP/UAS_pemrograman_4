package com.nyoba.uas.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMakanan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Makanan> listDataMakanan;
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
    public List<Makanan> getListDataMakanan() {
        return listDataMakanan;
    }
    public void setListDataMakanan(List<Makanan> listDataMakanan) {
        this.listDataMakanan = listDataMakanan;
    }
}