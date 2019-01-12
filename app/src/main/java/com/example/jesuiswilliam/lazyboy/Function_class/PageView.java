package com.example.jesuiswilliam.lazyboy.Function_class;


import android.content.Context;
import android.support.constraint.ConstraintLayout;

public abstract class PageView extends ConstraintLayout {
    public PageView(Context context) {
        super(context);
    }
    public abstract void refresh();
}