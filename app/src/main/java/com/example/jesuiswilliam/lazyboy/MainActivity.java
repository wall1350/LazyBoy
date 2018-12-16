package com.example.jesuiswilliam.lazyboy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jesuiswilliam.lazyboy.Fragment.AccountFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.ActivityFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.HomeFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.InfoFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.OutfitFragment;
import com.example.jesuiswilliam.lazyboy.Fragment.TestFragment;


public class MainActivity extends AppCompatActivity
        implements  BottomNavigationView.OnNavigationItemSelectedListener{
    private Intent intent = new Intent();

    private LinearLayout linear_Activity ;
    private ConstraintLayout con_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);


    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;
        switch (menuItem.getItemId()){
            case R.id.navigation_account:

               fragment = new AccountFragment();
                break;
            case R.id.navigation_activity:

                fragment = new ActivityFragment();
//
//                linear_Activity = (LinearLayout)findViewById(R.id.linear_Activity);
//                con_Activity = (ConstraintLayout)findViewById(R.id.mConstraintLayout_Activity);
//                CardView c1 = new CardView(this);
//                TextView t1 = new TextView(this);
//                t1.setText("TEXT");
//                c1.addView(t1);
//                // linear_Activity.addView(c1);
//                con_Activity.addView(c1);


                break;
            case R.id.navigation_home:

                fragment = new HomeFragment();
                break;
            case R.id.navigation_info:

                fragment = new InfoFragment();
                break;
            case R.id.navigation_outfit:

                fragment = new OutfitFragment();
                break;

        }
        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();


            return true;
        }
        return false;
    }
}
