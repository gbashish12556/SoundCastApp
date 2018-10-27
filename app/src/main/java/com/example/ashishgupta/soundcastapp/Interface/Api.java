package com.example.ashishgupta.soundcastapp.Interface;


import com.example.ashishgupta.soundcastapp.Pojo.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

 @GET("/things/zKWW.json")
 Call<ResultResponse> getSongs();

}