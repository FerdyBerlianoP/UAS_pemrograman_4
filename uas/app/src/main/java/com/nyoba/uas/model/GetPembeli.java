package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPembeli {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Pembeli> listDataPembeli;
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
    public List<Pembeli> getListDataPembeli() {
        return listDataPembeli;
    }
    public void setListDataPembeli(List<Pembeli> listDataPembeli) {
        this.listDataPembeli = listDataPembeli;
    }
}