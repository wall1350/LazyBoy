package com.example.jesuiswilliam.lazyboy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jesuiswilliam.lazyboy.Function_class.Webview_Vc;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import com.example.jesuiswilliam.lazyboy.R;

public class AccountFragment extends Fragment {
    private TextView user_email;
    private View view;
    private FirebaseAuth mAuth1;
    private FirebaseUser user;
    private Button log_out;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAuth1 = FirebaseAuth.getInstance();
        user = mAuth1.getCurrentUser();
        view = inflater.inflate(R.layout.account, container, false);
        user_email = (TextView) view.findViewById(R.id.user_email);
        user_email.setText("用戶："+user.getEmail());
        log_out = (Button)view.findViewById(R.id.log_out);


        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth1.signOut();
                getActivity().finish();
            }
        });

        return view;
    }
}
