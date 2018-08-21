package com.principal.subnetting.easy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NewsActivity extends AppCompatActivity {

    private ImageView imageNewsOne, imageNewsTwo, imageNewsThree, imageNewsFour, imageNewsFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        imageNewsOne = findViewById(R.id.image_news_one);
        imageNewsTwo = findViewById(R.id.image_news_two);
        imageNewsThree = findViewById(R.id.image_news_three);
        imageNewsFour = findViewById(R.id.image_news_four);
        imageNewsFive = findViewById(R.id.image_news_five);

        imageNewsOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewsActivity.this, ViewfinderByeIpv.class);
                startActivity(intent);
            }
        });


        imageNewsTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewsActivity.this, ViewfinderConvergingNetworks.class);
                startActivity(intent);
            }
        });

        imageNewsThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewsActivity.this, ViewfinderIpvSix.class);
                startActivity(intent);
            }
        });

        imageNewsFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewsActivity.this, ViewfinderOpticalFiber.class);
                startActivity(intent);
            }
        });

        imageNewsFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewsActivity.this, ViewfinderCiscoDay.class);
                startActivity(intent);
            }
        });


    }
}
