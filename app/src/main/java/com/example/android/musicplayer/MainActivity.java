package com.example.android.musicplayer;

import android.app.Activity;
import android.view.View;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = (Button) findViewById(R.id.button_play);
        Button buttonPause = (Button) findViewById(R.id.button_pause);
        Button buttonStop = (Button) findViewById(R.id.button_stop);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(getApplicationContext(), "I'm done :)", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Stopping...", Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.song);
            }
        });

    }
}