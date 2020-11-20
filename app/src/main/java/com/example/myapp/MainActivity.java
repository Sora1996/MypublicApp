package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.transition.Fade;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {//首页


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //退出时使用
        getWindow().setExitTransition(new Fade());
        //第一次进入时使用
        getWindow().setEnterTransition(new Fade());
        //再次进入时使用
        getWindow().setReenterTransition(new Fade());
        setContentView(R.layout.activity_main);
        //倒计时
        final int TOTAL_TIME = 5000;
        final int ONECE_TIME = 1000;
         final TextView timeText=findViewById(R.id.time);
         CountDownTimer countDownTimer = new CountDownTimer(TOTAL_TIME, ONECE_TIME) {
            @Override
            public void onTick(long times) {
                String value = String.valueOf((int) (times / 1000));
                timeText.setText(value);
            }
            @Override
            public void onFinish() {
                timeText.setText("0");
            }
        };
        countDownTimer.start();


        // 闪屏的核心代码
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,
                        LoginActivity.class); // 从启动动画ui跳转到主ui
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,
                        R.anim.fade_out);
                MainActivity.this.finish(); // 结束启动动画界面

            }
        }, 5000); // 启动动画持续5秒钟
    }


}