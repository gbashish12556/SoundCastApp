package com.example.ashishgupta.soundcastapp.View;

import com.example.ashishgupta.soundcastapp.Pojo.Song;

import java.util.List;

public interface ResultView
{

     public void fetchDataSuccess(List<Song> songs);
     public void fetchDataFailed(String message);
}
