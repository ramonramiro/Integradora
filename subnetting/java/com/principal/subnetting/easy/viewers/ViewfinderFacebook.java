package com.principal.subnetting.easy.viewers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.principal.subnetting.easy.R;

public class ViewfinderFacebook extends AppCompatActivity {

    final String url = "https://www.facebook.com/UTNGDOLORESHIDALGO-222209577812067/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfinder_facebook);


        WebView webFacebook = findViewById(R.id.web_view_viewfinder_facebook);


        webFacebook.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webFacebook.getSettings();
        settings.setJavaScriptEnabled(true);
        webFacebook.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
