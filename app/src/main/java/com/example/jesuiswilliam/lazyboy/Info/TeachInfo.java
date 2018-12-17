package com.example.jesuiswilliam.lazyboy.Info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.jesuiswilliam.lazyboy.*;//加這一句，因為我分了資料夾
public class TeachInfo extends PageView {
    public TeachInfo(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.info_teachinfo, null);
        addView(view);
    }

    @Override
    public void refresh() {
    }
}