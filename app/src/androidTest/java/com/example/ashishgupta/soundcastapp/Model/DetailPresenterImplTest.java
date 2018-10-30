package com.example.ashishgupta.soundcastapp.Model;

import android.content.Context;

import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.View.DetailView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailPresenterImplTest {

    private Context context;
    private ArrayList<Song> songs;
    private DetailView detailView;
    private DetailPresenterImpl detailPresenterImpl;

    @Before
    public void setUp() throws Exception {

        context = Mockito.mock(Context.class);
        detailView = Mockito.mock(DetailView.class);

        songs  = new ArrayList<>();
        Song song1  = new Song();
        song1.setLink("https://static.talview.com/hiring/android/soundcast/mp3/fast-and-furious.mp3");
        songs.add(song1);

        Song song2  = new Song();
        song2.setLink("https://static.talview.com/hiring/android/soundcast/mp3/fast-and-furious.mp3");
        songs.add(song2);

        Song song3  = new Song();
        song3.setLink("https://static.talview.com/hiring/android/soundcast/mp3/fast-and-furious.mp3");
        songs.add(song3);

        detailPresenterImpl  = new DetailPresenterImpl(detailView,context, songs, 1);

    }

    @After
    public void tearDown() throws Exception {
        context = null;
        detailView = null;
        songs = null;
    }

    @Test
    public void playNextTest() {

       detailPresenterImpl.playNext();
       verify(detailView).playSuccess(2);

    }

    @Test
    public void playPreviousTest() {

        detailPresenterImpl.playPrevious();
        verify(detailView).playSuccess(0);

    }

    @Test
    public void playSongTest() {

        detailPresenterImpl.playSong();
        verify(detailView).playSuccess(1);

    }

    @Test
    public void stopSongTest() {

        detailPresenterImpl.stopSong();
        verify(detailView).playSuccess(1);

    }
}