package com.nyoba.uas.rest;

import com.nyoba.uas.model.GetPembeli;
import com.nyoba.uas.model.PostPutDelPembeli;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterfacePembeli {
    @GET("Pembeli_android")
    Call<GetPembeli> getPembeli();
    @FormUrlEncoded
    @POST("pembeli")
    Call<PostPutDelPembeli> postPembeli(@Field("nama") String nama);
    @FormUrlEncoded
    @PUT("pembeli")
    Call<PostPutDelPembeli> putPembeli(@Field("id_pembeli") String id_pembeli,
                                       @Field("nama") String nama);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pembeli", hasBody = true)
    Call<PostPutDelPembeli> deletePembeli(@Field("id_pembeli") String id_pembeli);
}