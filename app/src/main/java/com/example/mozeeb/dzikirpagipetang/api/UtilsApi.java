package com.example.mozeeb.dzikirpagipetang.api;

public class UtilsApi {
    public static final String URL_API = "http://20.20.20.243/dzikir-api/";

    //mendeklarasikan interface apiservice
    public static ApiService getApiService(){
        return RetrofitClient.getClient(URL_API).create(ApiService.class);
    }
}
