package com.example.ashishgupta.soundcastapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.ashishgupta.soundcastapp.Model.DetailPresenterImpl;
import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.Presenter.DetailPresenter;
import com.example.ashishgupta.soundcastapp.R;
import com.example.ashishgupta.soundcastapp.View.DetailView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private ImageView previosuButton, nextButton, playButton, songIcon, backButton;
    private boolean isMusicPlaying = false;
    private int currentSongPosition = 0;
    private List<Song> songs;
    private Intent serviceIntent;
    private DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        songIcon = findViewById(R.id.activity_detail_song_icon);

        if (getIntent() != null) {

            songs = (List<Song>) getIntent().getSerializableExtra("songs");
            currentSongPosition = getIntent().getIntExtra("position",0);
            Picasso.get().load(songs.get(currentSongPosition).getThumbnail()).into(songIcon);

        }

        detailPresenter = new DetailPresenterImpl(DetailActivity.this,this,songs,currentSongPosition);

        previosuButton = findViewById(R.id.activity_detail_previous_song_button);
        nextButton = findViewById(R.id.activity_detail_next_song_button);
        playButton = findViewById(R.id.activity_detail_play_pause_button);
        backButton = findViewById(R.id.activity_detail_back_button_arrow);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                detailPresenter.playNext();

            }

        });

        previosuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

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

        Picasso.get().load(songs.get(postion).getThumbnail()).into(songIcon);

    }

}
