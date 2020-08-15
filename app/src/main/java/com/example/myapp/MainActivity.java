package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {//首页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startLoginActivity(View view){//进入loginactivity，并且停止此activity
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void exitMainActivity(View view){//退出程序
        this.finish();
    }
}