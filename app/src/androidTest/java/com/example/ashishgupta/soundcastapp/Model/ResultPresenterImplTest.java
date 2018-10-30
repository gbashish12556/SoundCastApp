package com.example.ashishgupta.soundcastapp.Model;

import com.example.ashishgupta.soundcastapp.Pojo.ResultResponse;
import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.Utils.RetrofitClient;
import org.junit.Test;
import java.io.IOException;
import java.util.List;
import retrofit2.Response;
import static org.junit.Assert.*;

public class ResultPresenterImplTest {

    @Test
    public void fetchDataSuccess(){

        retrofit2.Call<ResultResponse> call = RetrofitClient.getInstance().getApi().getSongs();
        Response<ResultResponse> response = null;
        try {
            response = call.execute();
            List<Song> songs = response.body().getSongs();
            assertTrue(response.isSuccessful());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}