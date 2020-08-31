package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class BodyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView account=findViewById(R.id.body_textView_account);
        account.setText(name);
    }

    public void  exit(View view){
        this.onBackPressed();
    }

    protected void stop(){
        this.onDestroy();
    }

    public void trick(View view){
        TextView title=findViewById(R.id.b_title);
        TextView message=findViewById(R.id.b_message);
        title.setText("you say:");
        message.setText("bye bye!");
        //定时器
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }, 5000);    //延时5s执行
    }

    //退出再次确认功能
    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle("确认退出吗？")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作
                        startActivity(new Intent(BodyActivity.this,MainActivity.class));
                        BodyActivity.this.finish();
                    }
                })
                .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“返回”后的操作,这里不设置没有任何操作
                    }
                }).show();
    }
}