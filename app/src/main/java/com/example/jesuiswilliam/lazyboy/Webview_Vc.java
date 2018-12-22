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

        String html = " ";
        html += "<html>\n" +
                "<head>\n" +
                "\t<style > \n" +
                "    img{\n" +
                "\t\theight: auto;\n" +
                "\t\twidth: 100%;\n" +
                "\t}\n" +
                "\t\t</style> \n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div id=\"\" class=\"\" data-label=\"\" style=\"text-align:center;\">\n" +
                "          <div id=\"\" class=\"\">\t\n" +
                "            <!-- Unnamed (Image) -->\n" +
                "            <div id=\"u219\" class=\"ax_default image\">\n" +
                "              <img id=\"u219_img\" class=\"img \" src=\"https://d2t44wh9rnwl5y.cloudfront.net/gsc/FRFBAV/61/3d/ab/613dab056428459ca676dcc59a3ae2ab/images/專欄/u201.jpg?token=8121d33e6e562fb02bb7475557eab1cd\">\n" +
                "            </div>\n" +
                "\t\t  <!-- Unnamed (Image) -->\n" +
                "            <div id=\"u218\" class=\"ax_default image\">\n" +
                "              <img id=\"u218_img\" class=\"img \" src=\"https://d2t44wh9rnwl5y.cloudfront.net/gsc/FRFBAV/61/3d/ab/613dab056428459ca676dcc59a3ae2ab/images/文章/u218.jpg?token=bf6770f3638da8c7f3e828f96e6f33a3\">\n" +
                "            </div>\n" +
                "\t\t\t\n" +
                "            <!-- Unnamed (Image) -->\n" +
                "            <div id=\"u220\" class=\"ax_default image\">\n" +
                "              <img id=\"u220_img\" class=\"img \" src=\"https://dxlfb468n8ekd.cloudfront.net/gsc/FRFBAV/61/3d/ab/613dab056428459ca676dcc59a3ae2ab/images/文章/u220.jpg?token=2464ef3132a55ea81e9e55d5526bf494\">\n" +
                "            </div>\n" +
                "\n" +
                "            <!-- Unnamed (Rectangle) -->\n" +
                "            <div id=\"u221\" class=\"ax_default paragraph\">\n" +
                "              <div id=\"\" class=\"\"></div>\n" +
                "              <div id=\"\" class=\"\">\n" +
                "                <p><span>一件完美剪裁與廓形的大衣都自帶一種高貴的氣質，換句話說，這樣的大衣\n" +
                "                不僅為你擺脫臃腫拖沓的形象，還能讓你看著氣度不凡，霸氣測漏！韓劇裡的霸道總裁歐巴們，\n" +
                "                之所以這麼得妹子們心，還不是人家會穿大衣。大部分現在流行的經典男士大衣，\n" +
                "                都是有各類軍裝演變而來，剪裁利落，因此大衣自帶帥酷氣質，當然前提是選好了大衣以及這件大衣適合你！</span></p>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "</body></html>";
        //webView.loadData(html, "text/html", "utf-8");
        webView.setWebViewClient(new myWebViewClient());
        webView.loadUrl("https://blog.csdn.net/mazhidong/article/details/68961818");
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
