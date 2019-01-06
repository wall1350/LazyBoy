package com.example.jesuiswilliam.lazyboy.Activity_files;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesuiswilliam.lazyboy.Fragment.HomeFragment;
import com.example.jesuiswilliam.lazyboy.R;
import com.example.jesuiswilliam.lazyboy.Webview_Vc;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class Vote extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View[] view_array;
    private ImageView[] imageView_array;
    private ImageView[] imageView_array_check;
    private Button[] button_array;
    private Button send,youCannotVote;
    private TextView[] textView_array;
    private ArrayList<Double> arrayList =new ArrayList();
    private LinearLayout lin_vote;
    private int index=0,counter=0,howManyOption=3;
    private boolean thisGuyCanVote = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);
        view_array= new View[howManyOption];
        imageView_array= new ImageView[howManyOption];
        imageView_array_check= new ImageView[howManyOption];
        button_array= new Button[howManyOption];
        textView_array= new TextView[howManyOption];

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                Toast toast = Toast.makeText(Vote.this, "刷新中，稍等", Toast.LENGTH_LONG);
                //顯示Toast
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        //過三秒後要做的事情
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                    }, 3000);
            }
        });//下拉刷新結束

        lin_vote = (LinearLayout)findViewById(R.id.lin_vote);
        for(counter=0;counter<howManyOption;counter++){
            //讀取其他的xml（普通版本）
            view_array[counter] = LayoutInflater.from(this).inflate(R.layout.card, null);
            //加入按鈕與照片還有下方文字
            imageView_array[counter] = view_array[counter].findViewById(R.id.cardlayout_imageView);
            imageView_array[counter].setImageResource(R.mipmap.hot_info_autumn);
            imageView_array_check[counter]=view_array[counter].findViewById(R.id.cardlayout_check);
            textView_array[counter] = view_array[counter].findViewById(R.id.card_text);
            String temp = "001  \n  男人不壞女人不愛  \n 約會就該穿出自我的個性！";
            textView_array[counter].setText(temp);
            button_array[counter] = view_array[counter].findViewById(R.id.cardlayout_button);
            //自定義按鈕事件
            button_array[counter].setId(index);
            index++;
            button_array[counter].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bt_event(v.getId() );
                }
            });
            lin_vote.addView(view_array[counter]); //加入畫面
        }//the end of for loop

        if(thisGuyCanVote){
            send = new Button(this);
            send.setBackgroundColor(getResources().getColor(R.color.BottomNevigationBarYellow));
            send.setId(index);
            send.setText("送出");
            index++;
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = arrayList.toString();
                    Toast toast = Toast.makeText(Vote.this,
                            "您選了! "+s, Toast.LENGTH_LONG);
                    //顯示Toast
                    toast.show();
                }
            });
            lin_vote.addView(send);
        }
        else{
            youCannotVote = new Button(this);
            youCannotVote.setBackgroundColor(getResources().getColor(R.color.BottomNevigationBarYellow));
            youCannotVote.setId(index);
            youCannotVote.setText("您已經投票過了");
            youCannotVote.setEnabled(false);
            index++;
            lin_vote.addView(youCannotVote);
        }



    }
    public  void bt_event(int i){
        if(imageView_array_check[i].getVisibility()==INVISIBLE){
            imageView_array_check[i].setVisibility(VISIBLE);
            Toast toast = Toast.makeText(Vote.this,
                    "您選擇了第"+(i+1)+"個", Toast.LENGTH_LONG);
            //顯示Toast
            toast.show();
            Double d = new Double(i);;
            arrayList.add(d);
        }
        else{
            imageView_array_check[i].setVisibility(INVISIBLE);
            Toast toast = Toast.makeText(Vote.this,
                    "您取消選擇第"+(i+1)+"個", Toast.LENGTH_LONG);
            //顯示Toast
            toast.show();
            Double d = new Double(i);
            arrayList.remove(d);
        }
    }

}
