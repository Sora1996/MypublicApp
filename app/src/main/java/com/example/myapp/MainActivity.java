package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;


import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;


public class MainActivity extends AppCompatActivity {//首页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startLoginActivity(View view){//进入loginactivity，并且停止此activity
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this);
        ActivityCompat.startActivity(MainActivity.this,
                new Intent(MainActivity.this, LoginActivity.class), optionsCompat.toBundle());
        this.onPause();
    }

    public void exitMainActivity(View view){//退出程序
        this.finish();
    }

}