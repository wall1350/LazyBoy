package com.example.jesuiswilliam.lazyboy.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.jesuiswilliam.lazyboy.*;//加這一句，因為我分了資料夾
import com.example.jesuiswilliam.lazyboy.Info.HotInfo;
import com.example.jesuiswilliam.lazyboy.Info.LatestInfo;
import com.example.jesuiswilliam.lazyboy.Info.TeachInfo;
import com.example.jesuiswilliam.lazyboy.R;
import com.example.jesuiswilliam.lazyboy.Test;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {
    private View view,view2,view3 ;//view1是主體,view2,3是卡片
    private ImageView i;//給view2卡片的圖
    private Button b;//給view2卡片的按鈕
    private LinearLayout linear_Info ;//主體的佈局layout
    private ConstraintLayout con_Info;
    private TabLayout myTablayout;
    private ViewPager mViewPager;
    private List<View> pageList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.info, null);

        pageList = new ArrayList<>();
        pageList.add(new HotInfo(getContext()));
        pageList.add(new LatestInfo(getContext()));
        pageList.add(new TeachInfo(getContext()));

        mViewPager = (ViewPager)view.findViewById(R.id.pager);
        myTablayout = (TabLayout)view.findViewById(R.id.tabs＿Info);
        myTablayout.addTab(myTablayout.newTab().setText("熱門文章"));
        myTablayout.addTab(myTablayout.newTab().setText("最新消息"));
        myTablayout.addTab(myTablayout.newTab().setText("穿搭教學"));

        mViewPager.setAdapter(new SamplePagerAdapter());

        myTablayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(myTablayout));

        return view;
    }

    public class SamplePagerAdapter extends PagerAdapter {


        @Override
        public int getCount() { return pageList.size(); }

        @Override
        public boolean isViewFromObject(View view, Object object) { return view == object; }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
        }
    }
}
