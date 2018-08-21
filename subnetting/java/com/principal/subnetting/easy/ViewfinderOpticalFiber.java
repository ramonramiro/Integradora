package com.principal.subnetting.easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewfinderOpticalFiber extends AppCompatActivity {

    final String url = "https://elpais.com/tecnologia/2018/07/05/actualidad/1530786971_845949.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfinder_optical_fiber);


        WebView webOpticalFiber = findViewById(R.id.web_viewfinder_fiber);


        webOpticalFiber.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webOpticalFiber.getSettings();
        settings.setJavaScriptEnabled(true);
        webOpticalFiber.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
