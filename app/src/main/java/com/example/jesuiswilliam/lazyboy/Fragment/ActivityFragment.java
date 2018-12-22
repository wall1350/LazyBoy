package com.example.jesuiswilliam.lazyboy.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jesuiswilliam.lazyboy.MainActivity;
import com.example.jesuiswilliam.lazyboy.R;
import com.example.jesuiswilliam.lazyboy.Test;

public class ActivityFragment extends Fragment {
    private View view,view2 ;//view1是主體,view2是卡片
    private ImageView i;//給view2卡片的圖
    private TextView t,t2;
    private LinearLayout linear_Activity ;//主體的佈局layout
    private ConstraintLayout con_Activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity, null);
        linear_Activity = (LinearLayout)view.findViewById(R.id.linear_Activity);
        con_Activity = (ConstraintLayout)view.findViewById(R.id.mConstraintLayout_Activity);

        //從系統找到另一個xml格式來載到畫面當中
        LayoutInflater inflater2 = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //讀取的card
        view2 = inflater2.inflate(R.layout.card_activity , null, true);

        //自定義圖片
        i =  view2.findViewById(R.id.cardlayout_imageView);
        i.setImageResource(R.mipmap.activity_date);
        t = view2.findViewById(R.id.textview_title);
        t2 = view2.findViewById(R.id.textView_content);
        t.setText("穿搭比賽：約會情境");
        t2.setText("今天高中的暗戀對象主動傳訊息約你到充滿共同回憶的咖啡店聊天，不知道她要和自己說什麼呢？\n" +
                "再次面對青春悸動的你，該怎麼樣才能給久違的對方留下帥氣又不至於疏遠的好印象？\n" +
                "一起努力搭配服裝接續一段不留遺憾的戀愛故事吧！\n" +
                "\n" +
                "【活動方式】\n" +
                "＊我要參加活動\n" +
                "Step1.  按下活動頁面的“我要投稿”\n" +
                "Step2. 上傳你帥氣的服裝搭配照片\n" +
                "Step3. 和我們分享你的搭配巧思和青春小故事吧！\n" +
                "\n" +
                "＊我要投票\n" +
                "活動期間每日每個帳號皆有一次投票機會，快來支持你心目中完美的服裝搭配吧！\n" +
                "\n" +
                "【活動獎勵】\n" +
                "＊參加獎\n" +
                "所有成功參與活動上傳照片的人，皆可獲得15獎勵點，每次成功投票皆可獲得1獎勵點\n" +
                "＊人氣獎\n" +
                "前三名可分別獲得150、100、75獎勵點\n" +
                "前十名可獲得20獎勵點\n" +
                "前三十名可獲得10獎勵點");
        linear_Activity.addView(view2); //加入畫面上

        return view;
    }
}
