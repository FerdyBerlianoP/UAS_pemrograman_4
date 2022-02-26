package com.nyoba.uas.rest;

import com.nyoba.uas.model.GetPesan;
import com.nyoba.uas.model.PostPutDelPesan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterfacePesan {
    @GET("Pesan_android")
    Call<GetPesan> getPesan();
    @FormUrlEncoded
    @POST("pesan")
    Call<PostPutDelPesan> postPesan(@Field("pembeli") String pembeli,
                                        @Field("makanan") String makanan,
                                        @Field("minuman") String minuman);
    @FormUrlEncoded
    @PUT("pesan")
    Call<PostPutDelPesan> putPesan(@Field("id_pesan") String id_pesan,
                                       @Field("pembeli") String pembeli,
                                       @Field("makanan") String makanan,
                                       @Field("minuman") String minuman);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "pesan", hasBody = true)
    Call<PostPutDelPesan> deletePesan(@Field("id_pesan") String id_pesan);
}