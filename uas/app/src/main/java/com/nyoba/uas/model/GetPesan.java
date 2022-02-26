package com.nyoba.uas.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPesan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Pesan> listDataPesan;
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
    public List<Pesan> getListDataPesan() {
        return listDataPesan;
    }
    public void setListDataPesan(List<Pesan> listDataPesan) {
        this.listDataPesan = listDataPesan;
    }
}