package com.nyoba.uas.rest;

import com.nyoba.uas.model.GetMakanan;
import com.nyoba.uas.model.PostPutDelMakanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("Makanan_android")
    Call<GetMakanan> getMakanan();
    @FormUrlEncoded
    @POST("makanan")
    Call<PostPutDelMakanan> postMakanan(@Field("nama_makanan") String nama_makanan,
                                      @Field("harga_makanan") String harga_makanan);
    @FormUrlEncoded
    @PUT("makanan")
    Call<PostPutDelMakanan> putMakanan(@Field("id_makanan") String id_makanan,
                                     @Field("nama_makanan") String nama_makanan,
                                     @Field("harga_makanan") String harga_makanan);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "makanan", hasBody = true)
    Call<PostPutDelMakanan> deleteMakanan(@Field("id_makanan") String id_makanan);
}
