package com.example.ashishgupta.soundcastapp.Activities;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.ashishgupta.soundcastapp.Model.DetailPresenterImpl;
import com.example.ashishgupta.soundcastapp.Pojo.Song;
import com.example.ashishgupta.soundcastapp.Presenter.DetailPresenter;
import com.example.ashishgupta.soundcastapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailActivityTest {

    @Rule
    public ActivityTestRule<DetailActivity> activityActivityTestRule = new ActivityTestRule<DetailActivity>(DetailActivity.class);

    DetailPresenterImpl detailPresenter = null;
    DetailActivity detailActivity = null;
    ArrayList<Song> songs;

    @Spy
    Intent intent;

    @Before
    public void setUp() throws Exception {
        detailPresenter = Mockito.mock(DetailPresenterImpl.class);

        detailActivity = activityActivityTestRule.getActivity();
        detailActivity.detailPresenter = detailPresenter;

        songs  = new ArrayList<>();
        Song song1  = new Song();
        song1.setLink("https://static.talview.com/hiring/android/soundcast/mp3/fast-and-furious.mp3");
        song1.setThumbnail("https://static.talview.com/hiring/android/soundcast/thumbs/fast-and-furious.jpg");
        songs.add(song1);

        Song song2  = new Song();
        song2.setLink("https://static.talview.com/hiring/android/soundcast/mp3/fast-and-furious.mp3");
        song2.setThumbnail("https://static.talview.com/hiring/android/soundcast/thumbs/fast-and-furious.jpg");
        songs.add(song2);

        Song song3  = new Song();
        song3.setLink("https://static.talview.com/hiring/android/soundcast/mp3/fast-and-furious.mp3");
        song3.setThumbnail("https://static.talview.com/hiring/android/soundcast/thumbs/fast-and-furious.jpg");
        songs.add(song3);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void allViewsAreCorrect(){

        View view = detailActivity.findViewById(R.id.activity_detail_previous_song_button);
        assertNotNull(view);

        View view1 = detailActivity.findViewById(R.id.activity_detail_next_song_button);
        assertNotNull(view1);

        View view2 = detailActivity.findViewById(R.id.activity_detail_play_pause_button);
        assertNotNull(view2);

    }

    @Test
    public void checkPreviosButtonIsClicked(){

        onView(withId(R.id.activity_detail_previous_song_button)).perform(click());

        verify(detailActivity.detailPresenter).playPrevious();
    }

    @Test
    public void checkNextButtonIsClicked(){

        onView(withId(R.id.activity_detail_next_song_button)).perform(click());

        verify(detailActivity.detailPresenter).playNext();
    }

    @Test
    public void checkSongPlayButtonIsClicked(){

        detailActivity.isMusicPlaying = false;

        onView(withId(R.id.activity_detail_play_pause_button)).perform(click());

        verify(detailActivity.detailPresenter).playSong();
    }

    @Test
    public void checkSongStopButtonIsClicked(){

        detailActivity.isMusicPlaying = true;

        onView(withId(R.id.activity_detail_play_pause_button)).perform(click());

        verify(detailActivity.detailPresenter).stopSong();
    }

}