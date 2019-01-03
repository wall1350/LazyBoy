package com.example.jesuiswilliam.lazyboy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static com.example.jesuiswilliam.lazyboy.BuildConfig.DEBUG;

public class Webview_Vc extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 取消标题
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 进行全屏

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.web_view_layout);
        // 实例化WebView
        webView = (WebView) this.findViewById(R.id.wv_oauth);

        /**
         * 设置WebView的属性，此时可以去执行JavaScript脚本
         */
        webView.getSettings().setJavaScriptEnabled(true);

        //webView.loadData(html, "text/html", "utf-8");
        webView.setWebViewClient(new myWebViewClient());
        webView.loadUrl("file:///android_asset/website/index.html");
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) { //表示按返回键时的操作
                        webView.goBack(); //后退

                        //webview.goForward();//前进
                        return true; //已处理
                    }
                }
                return false;
            }
        });

    }

    private class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            webView.loadUrl(URL);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            if (DEBUG) {
                Log.d("ouo", " onPageFinished ");
            }
            super.onPageFinished(view, url);
        }


    }

}
