package com.example.jesuiswilliam.lazyboy.Outfit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.jesuiswilliam.lazyboy.Function_class.PageView;
import com.example.jesuiswilliam.lazyboy.R;

public class OutfitItem extends PageView {

    private ImageButton btnJacket;

    public OutfitItem(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.outfititem, null);

        btnJacket = view.findViewById(R.id.btnJacket);
        btnJacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.setClass(context,OutfitJacket.class);
                context.startActivity(intent);
            }
        });

        addView(view);

    }

    @Override
    public void refresh() {
    }

}
