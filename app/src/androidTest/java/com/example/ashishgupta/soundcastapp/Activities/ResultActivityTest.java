package com.example.ashishgupta.soundcastapp.Activities;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.ashishgupta.soundcastapp.Model.DetailPresenterImpl;
import com.example.ashishgupta.soundcastapp.Model.ResultPresenterImpl;
import com.example.ashishgupta.soundcastapp.Presenter.ResultPresenter;
import com.example.ashishgupta.soundcastapp.R;
import com.example.ashishgupta.soundcastapp.View.ResultView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ResultActivityTest {

    @Rule
    public ActivityTestRule<ResultActivity> activityActivityTestRule = new ActivityTestRule<ResultActivity>(ResultActivity.class);

    ResultPresenter resultPresenter = null;
    ResultActivity resultActivity = null    ;
    ResultView resultView;

    @Before
    public void setUp() throws Exception {

        resultView = Mockito.mock(ResultView.class);
        resultActivity = activityActivityTestRule.getActivity();
        resultPresenter = new ResultPresenterImpl(resultView);

    }

    @After
    public void tearDown() throws Exception {

        resultView = null;
        resultActivity = null;
        resultPresenter = null;
    }

    @Test
    public void allViewsAreCorrect(){

        View view = resultActivity.findViewById(R.id.activity_result_song_list_recyler_view);
        assertNotNull(view);

    }

}