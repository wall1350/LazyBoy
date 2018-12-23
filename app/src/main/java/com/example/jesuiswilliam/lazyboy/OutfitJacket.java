package com.example.jesuiswilliam.lazyboy;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.jesuiswilliam.lazyboy.Fragment.AccountFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.ActivityFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.HomeFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.InfoFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.OutfitFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.TestFragment;


public class OutfitJacket extends AppCompatActivity
        implements  BottomNavigationView.OnNavigationItemSelectedListener{

    private ImageButton imgJacket1;

    private View mBarView;
    // 主Layout的容器加载子Layout的View
    private ConstraintLayout mConstraintLayout;
    private Fragment testFragment = new TestFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfitjacket);
        //loadFragment(testFragment);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(this);
        imgJacket1 = findViewById(R.id.imgJacket3);
        imgJacket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.setClass(OutfitJacket.this,OutfitMoreJacket.class);
                startActivity(intent);

                //OutfitJacket.this.finish();
            }
        });
    }



    //    private boolean loadFragment(Fragment fragment) {
//        //switching fragment
//
//        if (fragment != null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragment_container1, fragment)
//                    .commit();
//            return true;
//        }
//        return false;
//    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;

        switch (menuItem.getItemId()){
            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;
            case R.id.navigation_activity:
                fragment = new ActivityFragment();
                break;
            case R.id.navigation_home:

                //fragment = new HomeFragment();
                break;
            case R.id.navigation_info:
                fragment = new InfoFragment();
                Intent intent = new Intent();
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.navigation_outfit:
                fragment = new OutfitFragment();
                break;

        }
        //return loadFragment(fragment);
        return true;
    }
}

