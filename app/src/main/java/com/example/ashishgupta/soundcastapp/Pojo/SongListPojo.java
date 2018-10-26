package com.example.ashishgupta.soundcastapp.Pojo;

import org.json.JSONException;
import org.json.JSONObject;

public class SongListPojo {

    private int songId;
    private String songThumbNail;
    private String songTitle;
    private String songLink;

    public SongListPojo(JSONObject song){

        try {

            this.songId = song.getInt("id");
            this.songTitle = song.getString("title");
            this.songLink = song.getString("link");
            this.songThumbNail = song.getString("thumbnail");

        } catch (JSONException e) {

            e.printStackTrace();

        }

    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongThumbNail() {
        return songThumbNail;
    }

    public void setSongThumbNail(String songThumbNail) {
        this.songThumbNail = songThumbNail;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

}
