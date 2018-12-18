package com.example.jesuiswilliam.lazyboy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

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
                intent.setClass(context,Test.class);
                context.startActivity(intent);
            }
        });

        addView(view);

    }

    @Override
    public void refresh() {
    }

}
