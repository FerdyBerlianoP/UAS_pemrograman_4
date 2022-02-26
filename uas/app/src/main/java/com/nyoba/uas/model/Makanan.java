package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class Makanan {
    @SerializedName("id_makanan")
    private String id_makanan;
    @SerializedName("nama_makanan")
    private String nama_makanan;
    @SerializedName("harga_makanan")
    private String harga_makanan;

    public Makanan(String id_makanan, String nama_makanan, String harga_makanan) {
        this.id_makanan = id_makanan;
        this.nama_makanan = nama_makanan;
        this.harga_makanan = harga_makanan;
    }
    public String getId() {
        return id_makanan;
    }
    public void setId(String id_makanan) {
        this.id_makanan = id_makanan;
    }
    public String getMakanan() {
        return nama_makanan;
    }
    public void setMakanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }
    public String getHarga() {
        return harga_makanan;
    }
    public void setHarga(String harga_makanan) {
        this.harga_makanan = harga_makanan;
    }
}
