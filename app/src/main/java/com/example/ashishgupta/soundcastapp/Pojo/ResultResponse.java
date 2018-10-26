package com.example.ashishgupta.soundcastapp.Pojo;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

public class ResultResponse {

    @SerializedName("songs")
    JSONArray songList;

    public JSONArray getSongList() {
        return songList;
    }

    public void setSongList(JSONArray songList) {
        this.songList = songList;
    }

}
