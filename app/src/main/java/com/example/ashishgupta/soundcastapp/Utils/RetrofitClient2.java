package com.example.ashishgupta.soundcastapp.Utils;

import com.example.ashishgupta.soundcastapp.Interface.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient2 {

    public static final String BASE_URL = "https://www.jasonbase.com";
    private static RetrofitClient2 mRetrofitInstance;
    private Retrofit retrofit;

    private RetrofitClient2(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetrofitClient2 getInstance(){
        if(mRetrofitInstance == null) {
            mRetrofitInstance = new RetrofitClient2();
        }
        return mRetrofitInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}