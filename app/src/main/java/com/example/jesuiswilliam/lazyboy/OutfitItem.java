package com.example.jesuiswilliam.lazyboy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class OutfitItem extends PageView{
    public OutfitItem(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.outfititem, null);

        addView(view);

    }

    @Override
    public void refresh() {

    }
}

