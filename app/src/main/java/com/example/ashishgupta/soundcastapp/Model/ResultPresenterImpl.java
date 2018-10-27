package com.example.ashishgupta.soundcastapp.Model;

import com.example.ashishgupta.soundcastapp.Pojo.ResultResponse;
import com.example.ashishgupta.soundcastapp.Presenter.ResultPresenter;
import com.example.ashishgupta.soundcastapp.Utils.RetrofitClient;
import com.example.ashishgupta.soundcastapp.View.ResultView;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultPresenterImpl implements ResultPresenter {

    ResultView mResultView;

    public ResultPresenterImpl(ResultView resultView ){
        this.mResultView = resultView;
    }

    @Override
    public void fetchData() {

        retrofit2.Call<ResultResponse> call = RetrofitClient.getInstance().getApi().getSongs();

        call.enqueue(new Callback<ResultResponse>() {

            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {

                if (response.code() == 200) {

                    mResultView.fetchDataSuccess(response.body().getSongs());

                }
                else {

                    try {

                        mResultView.fetchDataFailed(response.errorBody().string());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {

            }

        });

    }

}
