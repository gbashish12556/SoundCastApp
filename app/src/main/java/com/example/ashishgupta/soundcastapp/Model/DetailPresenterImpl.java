package com.example.ashishgupta.soundcastapp.Model;

import android.content.Context;
import android.content.Intent;
import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.Presenter.DetailPresenter;
import com.example.ashishgupta.soundcastapp.Services.BackgroundMusicService;
import com.example.ashishgupta.soundcastapp.View.DetailView;
import java.util.List;

public class DetailPresenterImpl implements DetailPresenter {

    private DetailView detailView;
    private Context ctx;
    private Intent serviceIntent;
    private Boolean isMusicPlaying = false;
    private int currentSongPosition = 0;
    private List<Song> songs;

    public DetailPresenterImpl(DetailView detailView, Context ctx, List<Song> songs, int position) {

        this.detailView = detailView;
        this.currentSongPosition = position;
        this.songs = songs;
        this.ctx = ctx;
        serviceIntent = new Intent(ctx,BackgroundMusicService .class);

    }


    @Override
    public void playNext() {

        if (currentSongPosition < songs.size()-1) {

            ctx.stopService(serviceIntent);
            currentSongPosition = currentSongPosition+1;
            serviceIntent.putExtra("song_link", songs.get(currentSongPosition).getLink());

            if (isMusicPlaying) {

                ctx.startService(serviceIntent);

            }

        }

        detailView.playSuccess(currentSongPosition);

    }

    @Override
    public void playPrevious() {

        if (currentSongPosition > 0) {

            ctx.stopService(serviceIntent);

            currentSongPosition = currentSongPosition-1;

            serviceIntent.putExtra("song_link", songs.get(currentSongPosition).getLink());

            if (isMusicPlaying) {

                ctx.startService(serviceIntent);

            }

        }

        detailView.playSuccess(currentSongPosition);

    }

    @Override
    public void playSong() {

        serviceIntent.putExtra("song_link", songs.get(currentSongPosition).getLink());

        if (isMusicPlaying) {

            ctx.stopService(serviceIntent);
            isMusicPlaying = false;

        }
        else {

            ctx.startService(serviceIntent);
            isMusicPlaying = true;

        }

        detailView.playSuccess(currentSongPosition);

    }

    @Override
    public void stopSong() {

        ctx.stopService(serviceIntent);
        detailView.playSuccess(currentSongPosition);

    }

}
