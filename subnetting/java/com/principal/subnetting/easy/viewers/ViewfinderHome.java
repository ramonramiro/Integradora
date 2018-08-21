package com.principal.subnetting.easy.viewers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.principal.subnetting.easy.R;


public class ViewfinderHome extends AppCompatActivity {


    final String url = "http://www.utng.edu.mx/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfinder_home);


        WebView webHome = findViewById(R.id.web_viewfinder_home);


        webHome.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webHome.getSettings();
        settings.setJavaScriptEnabled(true);
        webHome.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
