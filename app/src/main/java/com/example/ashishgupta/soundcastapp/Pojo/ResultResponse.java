package com.example.ashishgupta.soundcastapp.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultResponse {

    @SerializedName("songs")
    @Expose
    private ArrayList<Song> songs = null;

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

}

