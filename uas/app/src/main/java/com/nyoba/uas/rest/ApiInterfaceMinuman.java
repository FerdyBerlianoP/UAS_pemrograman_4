package com.nyoba.uas.rest;

import com.nyoba.uas.model.GetMinuman;
import com.nyoba.uas.model.PostPutDelMinuman;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterfaceMinuman {
    @GET("Minuman_android")
    Call<GetMinuman> getMinuman();
    @FormUrlEncoded
    @POST("minuman")
    Call<PostPutDelMinuman> postMinuman(@Field("nama_minuman") String nama_minuman,
                                        @Field("harga_minuman") String harga_minuman);
    @FormUrlEncoded
    @PUT("minuman")
    Call<PostPutDelMinuman> putMinuman(@Field("id_minuman") String id_minuman,
                                       @Field("nama_minuman") String nama_minuman,
                                       @Field("harga_minuman") String harga_minuman);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "minuman", hasBody = true)
    Call<PostPutDelMinuman> deleteMinuman(@Field("id_minuman") String id_minuman);
}