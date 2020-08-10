package com.example.activity2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    private Button button;
    MediaPlayer mediaPlayer;
    ImageView psy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaPlayer = null;

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

        psy = findViewById(R.id.imageView);
        psy.setImageResource(R.drawable.psy);
    }

    public void music(View view) {
        switch (view.getId()) {
            case R.id.button: // Play
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.newface_music);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stopMusic();
                    }
                });
                mediaPlayer.start();
                break;
            case R.id.button3: // Pause
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
                break;
            case R.id.button4: // Stop
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    stopMusic();
                }
                break;
        }
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }

    private void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}