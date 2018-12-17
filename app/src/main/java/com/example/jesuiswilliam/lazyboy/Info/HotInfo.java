package com.example.jesuiswilliam.lazyboy.Info;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jesuiswilliam.lazyboy.*;//加這一句，因為我分了資料夾

public class HotInfo extends PageView{
    private View view2,view3 ;//view1是主體,view2,3是卡片
    private ImageView i;//給view2卡片的圖
    private Button b;//給view2卡片的按鈕
    private ConstraintLayout con_hot;//此pageView子頁上的layout

    public HotInfo(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.info_hotinfo, null);

        //讀取其他的xml（pageView子頁版本）
        view2 = LayoutInflater.from(context).inflate(R.layout.card, null);
        con_hot = (ConstraintLayout)view.findViewById(R.id.con_hot);

        //在子頁上加入按鈕與照片
        //自定義圖片
        i =  view2.findViewById(R.id.cardlayout_imageView);
        i.setImageResource(R.drawable.icon_menu2);
        //自定義按鈕事件
        b = view2.findViewById(R.id.cardlayout_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setImageResource(R.drawable.icon_menu3);

                //page view子頁裡的按鈕實現跳頁
                Intent intent = new Intent();
                intent.setClass(context,Test.class);
                context.startActivity(intent);
            }
        });

        con_hot.addView(view2); //加入子頁畫面上
        addView(view);
    }

    @Override
    public void refresh() {
    }
}

