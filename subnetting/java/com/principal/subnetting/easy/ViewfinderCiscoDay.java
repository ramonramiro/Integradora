package com.principal.subnetting.easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewfinderCiscoDay extends AppCompatActivity {

    final String url = "http://www.utng.edu.mx/index.php/296-utng-cisco-day";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfinder_cisco_day);


        WebView webCiscoDay = findViewById(R.id.web_viewfinder_cisco);


        webCiscoDay.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webCiscoDay.getSettings();
        settings.setJavaScriptEnabled(true);
        webCiscoDay.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
