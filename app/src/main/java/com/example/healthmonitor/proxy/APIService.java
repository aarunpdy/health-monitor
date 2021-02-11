package com.example.healthmonitor.proxy;

import com.example.healthmonitor.model.event.HealthCard;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/posts")
    @FormUrlEncoded
    Call<HealthCard> getAllData();
}
