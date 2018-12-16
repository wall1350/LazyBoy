package com.example.jesuiswilliam.lazyboy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class OutfitOutfit extends PageView {

    public OutfitOutfit(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.outfitoutfit, null);

        addView(view);

    }


    @Override
    public void refresh() {

    }


}
