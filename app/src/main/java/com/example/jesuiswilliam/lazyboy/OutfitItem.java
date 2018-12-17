package com.example.jesuiswilliam.lazyboy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

