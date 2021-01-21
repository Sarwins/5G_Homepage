package com.example.a5g_app_project;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity {

    private WebView HomepageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        HomepageView = findViewById(R.id.homepage_webview);

        // java script 활성화
        HomepageView.getSettings().setJavaScriptEnabled(true);

        // WebChromeClient 설정 - 브라우저 이벤트 구현을 위해 필요
        HomepageView.setWebChromeClient(new WebChromeClient());

        // WebViewClient 설정 - 새 페이지를 띄울 때 새 창이 아닌 현재 view에서 띄우기 위해 필요
        HomepageView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 새 페이지를 띄울 때 현재 view에서 띄우도록 설정
                view.loadUrl(url);
                return true;
            }
        });

        HomepageView.loadUrl("https://www.naver.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK)&&HomepageView.canGoBack())
        {
            HomepageView.goBack();
            return true;
        }else{
            finish();
        }
        return true;
    }
}
