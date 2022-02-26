package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class Pesan {
    @SerializedName("id_pesan")
    private String id_pesan;
    @SerializedName("pembeli")
    private String pembeli;
    @SerializedName("makanan")
    private String makanan;
    @SerializedName("minuman")
    private String minuman;


    public Pesan(String id_pesan, String pembeli, String makanan, String minuman) {
        this.id_pesan = id_pesan;
        this.pembeli = pembeli;
        this.makanan = makanan;
        this.minuman = minuman;

    }
    public String getId() {
        return id_pesan;
    }
    public void setId(String id_pesan) {
        this.id_pesan = id_pesan;
    }
    public String getPembeli() {
        return pembeli;
    }
    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }
    public String getMakanan() {
        return makanan;
    }
    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }
    public String getMinuman() {
        return minuman;
    }
    public void setMinuman(String minuman) {
        this.minuman = minuman;
    }

}
