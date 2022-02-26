package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class Minuman {
    @SerializedName("id_minuman")
    private String id_minuman;
    @SerializedName("nama_minuman")
    private String nama_minuman;
    @SerializedName("harga_minuman")
    private String harga_minuman;

    public Minuman(String id_minuman, String nama_minuman, String harga_minuman) {
        this.id_minuman = id_minuman;
        this.nama_minuman = nama_minuman;
        this.harga_minuman = harga_minuman;
    }
    public String getId() {
        return id_minuman;
    }
    public void setId(String id) {
        this.id_minuman = id_minuman;
    }
    public String getMinuman() {
        return nama_minuman;
    }
    public void setMinuman(String nama_minuman) {
        this.nama_minuman = nama_minuman;
    }
    public String getHarga() {
        return harga_minuman;
    }
    public void setHarga(String harga_minuman) {
        this.harga_minuman = harga_minuman;
    }
}
