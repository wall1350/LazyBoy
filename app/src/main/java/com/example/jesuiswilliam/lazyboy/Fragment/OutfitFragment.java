package  com.example.jesuiswilliam.lazyboy.Fragment;


import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jesuiswilliam.lazyboy.Outfit.OutfitItem;
import com.example.jesuiswilliam.lazyboy.Outfit.OutfitOutfit;
import com.example.jesuiswilliam.lazyboy.R;
import java.util.ArrayList;
import java.util.List;

public class OutfitFragment extends Fragment {
    private View view;
    private LayoutInflater layoutInflater;
    private View OutfitOutfit,OutfitItem;
    private TabLayout myTablayout;
    private ViewPager mViewPager;
    private List<View> pageList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.outfit, container, false);

        layoutInflater = getLayoutInflater();
        //OutfitOutfit = layoutInflater.inflate(R.layout.outfitoutfit, null);
        //OutfitItem = layoutInflater.inflate(R.layout.outfititem, null);
        pageList = new ArrayList<>();
        pageList.add(new OutfitOutfit(getContext()));
        pageList.add(new OutfitItem(getContext()));


        mViewPager = (ViewPager)view.findViewById(R.id.pager);

        myTablayout = (TabLayout)view.findViewById(R.id.tabs);
        myTablayout.addTab(myTablayout.newTab().setText("今日穿搭"));
        myTablayout.addTab(myTablayout.newTab().setText("單品"));

        mViewPager.setAdapter(new SamplePagerAdapter());

        myTablayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(myTablayout));

        return view;
    }

    public class SamplePagerAdapter extends PagerAdapter {


        @Override
        public int getCount() { return pageList.size(); }

        @Override
        public boolean isViewFromObject(View view, Object object) { return view == object; }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
        }
    }




//    private void initData() {
//        pageList = new ArrayList<>();
//        pageList.add(new OutfitOutfit(view));
//    }
}
