package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class PostPutDelPesan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pesan mPesan;
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
    public Pesan getmPesan() {
        return mPesan;
    }
    public void setmPesan(Pesan Pesan) {
        mPesan = Pesan;
    }
}
