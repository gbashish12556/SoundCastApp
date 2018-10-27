package com.example.ashishgupta.soundcastapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.ashishgupta.soundcastapp.Adapter.SongListAdapter;
import com.example.ashishgupta.soundcastapp.Model.ResultPresenterImpl;
import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.Presenter.ResultPresenter;
import com.example.ashishgupta.soundcastapp.R;
import com.example.ashishgupta.soundcastapp.View.ResultView;
import java.io.Serializable;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements ResultView {

    ResultPresenter mResultPresenter;
    SongListAdapter.PostItemListener mPostItemListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mResultPresenter = new ResultPresenterImpl(ResultActivity.this);
        mResultPresenter.fetchData();

    }

    @Override
    public void fetchDataSuccess(List<Song> songs) {

        //RECYCLERVIEW
        RecyclerView rv= (RecyclerView) findViewById(R.id.activity_result_song_list_recyler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //ADAPTER
        SongListAdapter adapter=new SongListAdapter(this,songs, new SongListAdapter.PostItemListener() {

            @Override
            public void onPostClick(List<Song> songs, int position) {

                //Opening next activity and passoing song link to next activity
                Intent intent = new Intent(ResultActivity.this,DetailActivity.class);
                intent.putExtra("songs", (Serializable) songs);
                intent.putExtra("position",  position);
                startActivity(intent);

            }
        });

        rv.setAdapter(adapter);
    }

    @Override
    public void fetchDataFailed(String error) {

        Toast.makeText(this, "Fetch failed", Toast.LENGTH_LONG).show();

    }

}
