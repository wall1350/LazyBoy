package com.example.jesuiswilliam.lazyboy.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
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
    private Button b;//給view2卡片的按鈕
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
        view2 = inflater2.inflate(R.layout.layout_item_demo , null, true);

        //自定義圖片
        i =  view2.findViewById(R.id.cardlayout_imageView);
        i.setImageResource(R.drawable.icon_menu2);
        //自定義按鈕事件
        b = view2.findViewById(R.id.cardlayout_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //i.setImageResource(R.drawable.icon_menu3);
                Intent intent = new Intent();
                intent.setClass(getActivity(),Test.class);
                startActivity(intent);
            }
        });

        linear_Activity.addView(view2); //加入畫面上

        return view;
    }
}
