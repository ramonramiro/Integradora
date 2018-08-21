package com.principal.subnetting.easy.units;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.principal.subnetting.easy.R;
import com.principal.subnetting.easy.theory.TheoryFive;

public class UnitFive extends AppCompatActivity {

    private Button btPlay;
    private Button btPause;
    private Button btStop;
    private ImageView imageAlpha;
    private Button btTheory;

    private Animation animation;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_five);

        btPlay = findViewById(R.id.bt_play);
        btPause = findViewById(R.id.bt_pause);
        btStop =  findViewById(R.id.bt_stop);
        imageAlpha =  findViewById(R.id.image_alpha);
        btTheory = findViewById(R.id.bt_theory);

        btTheory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitFive.this, TheoryFive.class);
                startActivity(intent);
            }
        });

        animation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.blink_photo);
        initUI();
        initMediaPlayer();
    }

    public void initUI() {
        btPlay.setEnabled(true);
        btPause.setEnabled(false);
        btStop.setEnabled(false);
    }

    public void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(
                getApplicationContext(), R.raw.unit5);

    }

    public void play(View view) {
        try {
            mediaPlayer.start();
            imageAlpha.startAnimation(animation);
            btPause.setEnabled(true);
            btStop.setEnabled(true);
            btPlay.setEnabled(false);
        } catch (IllegalStateException e){
            Log.i("MediaPlayer", "Error: "+e.getMessage());
        }
    }


    public void pause(View view) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            imageAlpha.clearAnimation();
            btPlay.setEnabled(true);
            btStop.setEnabled(false);
        }
    }
    public void stop(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            initMediaPlayer();
            imageAlpha.clearAnimation();
            btPlay.setEnabled(true);
            btPause.setEnabled(false);
        }
    }

}
