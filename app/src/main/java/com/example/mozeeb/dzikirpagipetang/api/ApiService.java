package com.example.mozeeb.dzikirpagipetang.api;

import com.example.mozeeb.dzikirpagipetang.response.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("getData.php")
    Call<ResponseData> getAllData();
}
