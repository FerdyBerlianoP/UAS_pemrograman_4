package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class PostPutDelMinuman {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Minuman mMinuman;
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
    public Minuman getmMinuman() {
        return mMinuman;
    }
    public void setmMinuman(Minuman Minuman) {
        mMinuman = Minuman;
    }
}
