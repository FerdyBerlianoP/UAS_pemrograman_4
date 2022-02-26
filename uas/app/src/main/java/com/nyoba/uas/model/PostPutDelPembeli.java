package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class PostPutDelPembeli {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pembeli mPembeli;
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
    public Pembeli getmPembeli() {
        return mPembeli;
    }
    public void setmPembeli(Pembeli Pembeli) {
        mPembeli = Pembeli;
    }
}
