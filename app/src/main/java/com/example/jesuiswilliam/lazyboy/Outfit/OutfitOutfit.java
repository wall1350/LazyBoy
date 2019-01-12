package com.example.jesuiswilliam.lazyboy.Outfit;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.jesuiswilliam.lazyboy.Function_class.PageView;
import com.example.jesuiswilliam.lazyboy.R;

public class OutfitOutfit extends PageView {

    private ImageButton btnRelax, btnStreet, btnGen, btnJob;

    public OutfitOutfit(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.outfitoutfit, null);

        btnRelax = view.findViewById(R.id.btnRelax);
        btnRelax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.setClass(context,OutfitRelax.class);
                context.startActivity(intent);
            }
        });

        addView(view);

    }

    @Override
    public void refresh() {
    }

}
