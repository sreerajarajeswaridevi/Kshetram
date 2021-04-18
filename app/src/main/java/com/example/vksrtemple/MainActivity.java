package com.example.vksrtemple;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView web;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webview);
        if (savedInstanceState == null) {
            web.loadUrl("https://www.sreerajarajeswaridevi.org/android_app/");
            WebSettings webSettings = web.getSettings();
            webSettings.setJavaScriptEnabled(true);
            web.addJavascriptInterface(new WebAppBridge(this), "Android");
        } else {
            web.restoreState(savedInstanceState);
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        web.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        web.restoreState(savedInstanceState);
    }
}