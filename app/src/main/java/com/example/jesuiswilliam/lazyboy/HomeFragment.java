package com.example.jesuiswilliam.lazyboy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {
    private View view;
    private Button button;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.home, null);
//        Button button2 = (Button)findViewById(R.id.jump);
//    }
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.home, container, false);
    button = (Button) view.findViewById(R.id.jumpbt);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(getActivity(),Test.class);
            startActivity(intent);
//            finish();
        }
    });
    return view;
}
}


