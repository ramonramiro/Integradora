package com.principal.subnetting.easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ViewfinderIpvSix extends AppCompatActivity {

    final String url = "https://www.rau.edu.uy/ipv6/queesipv6.htm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfinder_ipv_six);

        WebView webIpvSix = findViewById(R.id.web_viewfinder_ipv6);


        webIpvSix.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webIpvSix.getSettings();
        settings.setJavaScriptEnabled(true);
        webIpvSix.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
