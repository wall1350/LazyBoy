package com.example.jesuiswilliam.lazyboy.Info;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jesuiswilliam.lazyboy.*;//加這一句，因為我分了資料夾

public class LatestInfo extends PageView{
    private View view1,view2,view3 ;//view1,2,3是卡片
    private ImageView i1,i2,i3;//給view2卡片的圖
    private Button b1,b2,b3;//給view2卡片的按鈕
    private LinearLayout lin_teach;//此pageView子頁上的layout

    public LatestInfo(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.info_latestinfo, null);

        //讀取其他的xml（pageView子頁版本）
        view1 = LayoutInflater.from(context).inflate(R.layout.card, null);
        view2 = LayoutInflater.from(context).inflate(R.layout.card, null);
        view3 = LayoutInflater.from(context).inflate(R.layout.card, null);

        lin_teach = (LinearLayout)view.findViewById(R.id.lin_latest);

        //在子頁上加入按鈕與照片
        //自定義圖片
        i1 =  view1.findViewById(R.id.cardlayout_imageView);
        i1.setImageResource(R.mipmap.info_latest_classic);
        //自定義按鈕事件
        b1 = view1.findViewById(R.id.cardlayout_button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //page view子頁裡的按鈕實現跳頁
                Intent intent = new Intent();
                intent.setClass(context,Webview_Vc.class);
                context.startActivity(intent);
            }
        });
        i2 =  view2.findViewById(R.id.cardlayout_imageView);
        i2.setImageResource(R.mipmap.hot_info_autumn);
        //自定義按鈕事件
        b2 = view2.findViewById(R.id.cardlayout_button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //page view子頁裡的按鈕實現跳頁
                Intent intent = new Intent();
                intent.setClass(context,Webview_Vc.class);
                context.startActivity(intent);
            }
        });
        i3 =  view3.findViewById(R.id.cardlayout_imageView);
        i3.setImageResource(R.mipmap.info_latest_bag);
        //自定義按鈕事件
        b3 = view3.findViewById(R.id.cardlayout_button);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //page view子頁裡的按鈕實現跳頁
                Intent intent = new Intent();
                intent.setClass(context,Webview_Vc.class);
                context.startActivity(intent);
            }
        });

        lin_teach.addView(view1); //加入子頁畫面上
        lin_teach.addView(view2); //加入子頁畫面上
        lin_teach.addView(view3); //加入子頁畫面上
        addView(view);
    }

    @Override
    public void refresh() {
    }
}

