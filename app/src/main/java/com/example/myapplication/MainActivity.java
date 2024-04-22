package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;



public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    private Timer timer;

    private ImageView[] imageViews;

    private int currentIndex;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    public void uc1ADC (View view){
        setContentView(R.layout.uc1);
    }

    public void backtohomebutton (View view){
        setContentView(R.layout.activity_main);

    }

    public void uc2ADC (View view){
        setContentView(R.layout.uc2);
    }

//    public void uc3ADC (View view){
//        setContentView(R.layout.uc3);
//
//    }

    public void uc4ADC (View view){
        setContentView(R.layout.uc4);
    }

    public void uc5ADC (View view){
        setContentView(R.layout.uc5);
    }

    public void uc1DPS (View view){
        setContentView(R.layout.uc1_shuiping2);
    }


    public void uc1DES (View view){
        setContentView(R.layout.uc1_kaozuo2);
    }



    public void uc3ADC(View view) {
        setContentView(R.layout.uc3);

        imageViews = new ImageView[5];
        imageViews[0] = findViewById(R.id.a);
        imageViews[1] = findViewById(R.id.b);
        imageViews[2] = findViewById(R.id.c);
        imageViews[3] = findViewById(R.id.d);
        imageViews[4] = findViewById(R.id.e);

        currentIndex = 0;
        handler = new Handler();

        // 创建定时器并设置定时任务
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 在定时任务中切换到下一个ImageView
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        showNextImage();
                    }
                });
            }
        }, 0, 2500); // 间隔2秒切换一次ImageView
    }
    private void showNextImage() {
        // 隐藏当前ImageView
        imageViews[currentIndex].setVisibility(View.INVISIBLE);

        // 切换到下一个ImageView
        currentIndex = (currentIndex + 1) % imageViews.length;

        // 显示下一个ImageView
        imageViews[currentIndex].setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 停止定时器
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }


}