package com.example.ashishgupta.soundcastapp.Utils;

import com.example.ashishgupta.soundcastapp.Interface.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient1 {

    public static final String BASE_URL = "https://static.talview.com/hiring/android/soundcast/";
    private static RetrofitClient1 mRetrofitInstance;
    private Retrofit retrofit;

    private RetrofitClient1(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetrofitClient1 getInstance(){
        if(mRetrofitInstance == null) {
            mRetrofitInstance = new RetrofitClient1();
        }
        return mRetrofitInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}