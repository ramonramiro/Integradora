package com.principal.subnetting.easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ViewfinderByeIpv extends AppCompatActivity {

    final String url = "https://www.xatakamovil.com/conectividad/se-acabaron-las-direcciones-ipv4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye_ipv_viewfinder);


        WebView webByeIpv = findViewById(R.id.web_view_bye_ipv);


        webByeIpv.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webByeIpv.getSettings();
        settings.setJavaScriptEnabled(true);
        webByeIpv.loadUrl(url);

    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
