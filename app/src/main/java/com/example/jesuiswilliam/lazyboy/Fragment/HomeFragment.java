package com.example.jesuiswilliam.lazyboy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import com.example.jesuiswilliam.lazyboy.Function_class.GlideImageLoader;
import com.example.jesuiswilliam.lazyboy.Outfit.OutfitRelax;
import com.example.jesuiswilliam.lazyboy.R;
import com.example.jesuiswilliam.lazyboy.Function_class.Webview_Vc;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

public class HomeFragment extends Fragment {
    private View view;
    private ImageButton btnnews,btntoday;
    List<Integer> images = new ArrayList<>();
    private Banner banner;

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home, container, false);

        btnnews = (ImageButton) view.findViewById(R.id.btnnews);
        btntoday = (ImageButton) view.findViewById(R.id.btntoday);

        btnnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),Webview_Vc.class);
                startActivity(intent);
                //getActivity().finish();
            }
        });

        btntoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),OutfitRelax.class);
                startActivity(intent);
                //getActivity().finish();
            }
        });

        images.add(R.drawable.home1);
        images.add(R.drawable.home2);
        images.add(R.drawable.home3);

        banner = view.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImages(images);
        banner.setImageLoader(new GlideImageLoader());
//        banner.setOnBannerListener(this);
        banner.setDelayTime(3000);
        banner.start();



        return view;
    }


}


