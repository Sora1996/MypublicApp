package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
    }

    public void regist(View view){//注册操作

        Toast.makeText(RegistActivity.this,"you click the regist button",Toast.LENGTH_LONG).show();
    }

    public void reset(View view){//清空文本编辑框中的信息
        EditText editText_account=findViewById(R.id.login_editText_account);
        EditText editText_password=findViewById(R.id.login_editText_password);
        editText_account.setText("");
        editText_password.setText("");
    }
}