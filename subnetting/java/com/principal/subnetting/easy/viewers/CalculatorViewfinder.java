package com.principal.subnetting.easy.viewers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.principal.subnetting.easy.R;

public class CalculatorViewfinder extends AppCompatActivity {

    final String url = "http://www.calculadora-redes.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_viewfinder);

        WebView webCalculator = findViewById(R.id.web_view_calculator);
        webCalculator.setWebViewClient(new MyWebViewClient());
        WebSettings settings = webCalculator.getSettings();
        settings.setJavaScriptEnabled(true);
        webCalculator.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient
    {

        public boolean shouldOverrideUrlLogding(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}