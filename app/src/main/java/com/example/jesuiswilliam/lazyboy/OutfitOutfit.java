package com.example.jesuiswilliam.lazyboy;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
