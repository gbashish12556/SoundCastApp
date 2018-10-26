package com.example.ashishgupta.soundcastapp.Pojo;

public class SongListPojo {

    private int songId;
    private String thumbnNailUrl;
    private String songName;
    private String songURL;

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getThumbnNailUrl() {
        return thumbnNailUrl;
    }

    public void setThumbnNailUrl(String thumbnNailUrl) {
        this.thumbnNailUrl = thumbnNailUrl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }

}
