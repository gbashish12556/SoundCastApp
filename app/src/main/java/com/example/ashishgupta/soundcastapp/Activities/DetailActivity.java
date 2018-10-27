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

    ImageView previosuButton, nextButton, playButton, songIcon;
    boolean isMusicPlaying = false;
    int currentSongPosition = 0;
    List<Song> songs;
    Intent serviceIntent;
    DetailPresenter detailPresenter;

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

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isMusicPlaying) {

                    detailPresenter.stopSong();
                    isMusicPlaying = false;
                    playButton.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);

                }
                else {

                    detailPresenter.playSong();
                    isMusicPlaying = true;
                    playButton.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);

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
