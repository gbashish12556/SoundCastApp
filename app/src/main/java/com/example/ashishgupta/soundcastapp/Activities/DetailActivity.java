package com.example.ashishgupta.soundcastapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.ashishgupta.soundcastapp.Model.DetailPresenterImpl;
import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.Presenter.DetailPresenter;
import com.example.ashishgupta.soundcastapp.R;
import com.example.ashishgupta.soundcastapp.View.DetailView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {

    ImageView previosuButton, nextButton, playButton, songIcon, backButton;
    boolean isMusicPlaying = false;
    int currentSongPosition = 0;
    ArrayList<Song> songs;
    Intent serviceIntent;
    DetailPresenter detailPresenter;
    ProgressBar dedicatedProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        songIcon = findViewById(R.id.activity_detail_song_icon);

        if (getIntent() != null) {

            songs = (ArrayList<Song>) getIntent().getSerializableExtra("songs");
            currentSongPosition = getIntent().getIntExtra("position",0);
            if(songs != null) {
                Picasso.get().load(songs.get(currentSongPosition).getThumbnail()).into(songIcon);
            }

        }

        detailPresenter = new DetailPresenterImpl(DetailActivity.this,this,songs,currentSongPosition);

        dedicatedProgressBar = findViewById(R.id.dedicated_progress_bar);
        previosuButton = findViewById(R.id.activity_detail_previous_song_button);
        nextButton = findViewById(R.id.activity_detail_next_song_button);
        playButton = findViewById(R.id.activity_detail_play_pause_button);
        backButton = findViewById(R.id.activity_detail_back_button_arrow);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dedicatedProgressBar.setVisibility(View.VISIBLE);
                if (isMusicPlaying) {

                    playButton.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                    isMusicPlaying = false;
                    detailPresenter.stopSong();

                }
                else {

                    playButton.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
                    isMusicPlaying = true;
                    detailPresenter.playSong();

                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dedicatedProgressBar.setVisibility(View.VISIBLE);
                detailPresenter.playNext();

            }

        });

        previosuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dedicatedProgressBar.setVisibility(View.VISIBLE);
                detailPresenter.playPrevious();

            }

        });

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                onBackPressed();

            }

        });

    }

    @Override
    public void onBackPressed() {

        detailPresenter.stopSong();
        super.onBackPressed();

    }

    @Override
    public void playSuccess(int postion) {
        dedicatedProgressBar.setVisibility(View.GONE);
        if(songs != null) {
            Picasso.get().load(songs.get(postion).getThumbnail()).into(songIcon);
        }

    }

}
