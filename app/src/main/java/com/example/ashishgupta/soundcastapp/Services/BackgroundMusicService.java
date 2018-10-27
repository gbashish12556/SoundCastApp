package com.example.ashishgupta.soundcastapp.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;


public class BackgroundMusicService extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("service_start", intent.getStringExtra("song_link"));

        player = new MediaPlayer();
        try {
            player.setDataSource(intent.getStringExtra("song_link"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);

        try {
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return START_STICKY;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }

    public void onPause() {

    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}