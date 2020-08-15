package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
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
}