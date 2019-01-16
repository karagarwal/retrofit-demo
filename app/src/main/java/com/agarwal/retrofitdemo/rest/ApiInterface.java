package com.agarwal.retrofitdemo.rest;

import com.agarwal.retrofitdemo.Model.HeritageCities;
import com.agarwal.retrofitdemo.Model.HomeCities;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("city_details.php")
    Call<List<HomeCities>> getCityDetails();

    @FormUrlEncoded
    @POST("category.php")
    Call<List<HeritageCities>> getDetails(
            @Field("category") String heritage,
            @Field("city") String city);
}
