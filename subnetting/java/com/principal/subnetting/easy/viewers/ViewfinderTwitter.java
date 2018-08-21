package com.principal.subnetting.easy.viewers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.principal.subnetting.easy.R;

public class ViewfinderTwitter extends AppCompatActivity {


    final String url = "https://twitter.com/utngdolores?lang=es";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfinder_twitter);

        WebView webTwitter = findViewById(R.id.web_view_viewfinder_twitter);


        webTwitter.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webTwitter.getSettings();
        settings.setJavaScriptEnabled(true);
        webTwitter.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
