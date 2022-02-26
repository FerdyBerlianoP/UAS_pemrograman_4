package com.nyoba.uas.model;
import com.google.gson.annotations.SerializedName;

public class Pembeli {
    @SerializedName("id_pembeli")
    private String id_pembeli;
    @SerializedName("nama")
    private String nama;


    public Pembeli(String id_pembeli, String nama) {
        this.id_pembeli = id_pembeli;
        this.nama = nama;

    }
    public String getId() {
        return id_pembeli;
    }
    public void setId(String id) {
        this.id_pembeli = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

}
