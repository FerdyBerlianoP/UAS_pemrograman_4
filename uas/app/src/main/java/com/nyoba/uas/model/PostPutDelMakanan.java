package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class PostPutDelMakanan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Makanan mMakanan;
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
    public Makanan getmMakanan() {
        return mMakanan;
    }
    public void setmMakanan(Makanan Makanan) {
        mMakanan = Makanan;
    }
}
