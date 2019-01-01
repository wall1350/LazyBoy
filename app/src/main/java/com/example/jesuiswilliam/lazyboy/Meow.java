package com.example.jesuiswilliam.lazyboy;

import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Meow extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private String userUID;
    private Button btnSubmit;
    private static String TAG = "Meow";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meow);

        auth = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(
                    @NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // 這裡是已登入，應跳轉至已登入的用戶畫面
                    Log.d("onAuthStateChanged", "登入:" +
                            user.getUid());
                    userUID = user.getUid();
                } else {
                    // 這邊應該留在登入畫面
                    Log.d("onAuthStateChanged", "已登出");
                }
            }
        };

        btnSubmit = this.findViewById(R.id.btnEmailSignIn);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        Button btnForgotPassword = this.findViewById(R.id.btnForgotPassword);
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 這邊在一個新的activity設計忘記密碼介面並把下方string改成edittext取得的email（email格式可用我這邊的isValidEmail()驗證
                resetPassword("u10516040@go.utaipei.edu.tw");
            }
        });

    }
    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    public void signOut(View view) {
        auth.getInstance()
                .signOut();

    }
    public void login(){
        String email = ((EditText)findViewById(R.id.etEmail))
                .getText().toString();
        String password = ((EditText)findViewById(R.id.etPassword))
                .getText().toString();
        if (isValidEmail(email) && !password.isEmpty()) {
            Log.d("AUTH", email+"/"+password);
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                // 這邊要跳到登入成功後的用戶介面
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Meow", "signInWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();

                            } else {
                                // 我這邊把註冊直接加進來，如果email沒在firebase就註冊新的。
                                register();
                                // If sign in fails, display a message to the user.
                                Log.w("Meow", "login:failure", task.getException());

                            }
                        }
                    });
        }
        else {
            // Tell user please enter valid email and password
        }
    }
    public void register() {
        String email = ((EditText)findViewById(R.id.etEmail))
                .getText().toString();
        String password = ((EditText)findViewById(R.id.etPassword))
                .getText().toString();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 顯示註冊新用戶成功、跳到用戶介面
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "註冊新用戶成功");
                            FirebaseUser user = auth.getCurrentUser();

                        } else {
                            // 用戶已經存在或email badly formatted 或 密碼長度小於6
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "用戶已存在", task.getException());

                        }
                    }
                });

    }

    private void updateUI(FirebaseUser user) {
        // update ui here
    }

    public void resetPassword(String email) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // 顯示email已經送出、看看要不要跳回原來頁面
                            Log.d(TAG, "Email sent.");
                        }
                        else {
                            // 顯示沒有這個 email
                            Log.wtf(TAG, "Email not found");
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authListener);
    }
}
