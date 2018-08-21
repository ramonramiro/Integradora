package com.principal.subnetting.easy.viewers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.principal.subnetting.easy.R;

public class VideoViewfinder extends AppCompatActivity {

    final String url = "https://www.youtube.com/watch?v=lEKR7WtKzDA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_viewfinder);


        WebView webVideo =(WebView) findViewById(R.id.web_viewfinder_video);
        webVideo.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webVideo.getSettings();
        settings.setJavaScriptEnabled(true);
        webVideo.loadUrl(url);
    }
    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}