package com.example.ashishgupta.soundcastapp.Utils;

import com.example.ashishgupta.soundcastapp.Interface.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "https://static.talview.com/hiring/android/soundcast/";
    private static RetrofitClient mRetrofitInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mRetrofitInstance == null) {
            mRetrofitInstance = new RetrofitClient();
        }
        return mRetrofitInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}