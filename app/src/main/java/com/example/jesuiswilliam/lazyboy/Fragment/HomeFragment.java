package com.example.jesuiswilliam.lazyboy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jesuiswilliam.lazyboy.R;
import com.example.jesuiswilliam.lazyboy.Test;

public class HomeFragment extends Fragment {
    private View view;
    private Button button;

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

        button = (Button) view.findViewById(R.id.jumpbt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),Test.class);
                startActivity(intent);
                //getActivity().finish();
            }
        });
        return view;
    }

}


