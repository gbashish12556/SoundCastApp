package com.example.ashishgupta.soundcastapp.Interface;


import com.example.ashishgupta.soundcastapp.Pojo.ResultResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

 @GET("/things/zKWW.json")
 Call<ResultResponse> getSongs();

}