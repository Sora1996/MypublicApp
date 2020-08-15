package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void login(View view){//登录操作
        //引用编写文本组件
        EditText editText_account=findViewById(R.id.login_editText_account);
        EditText editText_password=findViewById(R.id.login_editText_password);
        String name=editText_account.getText().toString();
        String pwd=editText_password.getText().toString();
        //调用dbopenhelp创建user表
        DBOpenHelper dbOpenHelper=new DBOpenHelper(this,"user.db",null,1);
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        //搜索用户名密码
        Cursor c=db.query("user_tb",null,"userID=? and pwd=?",new String[]{name,pwd},null,null,null);
        if(c!=null&&c.getCount()>1){
//            String[] cols=c.getColumnNames();
//            while (c.moveToNext()){
//                for (String ColumName:cols){
//                    Log.i("info",ColumName+":"+c.getString(c.getColumnIndex(ColumName)));
//                }
//            }

            Intent intent=new Intent(this,BodyActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
            c.close();
            db.close();
            this.finish();
        }else{
            Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
        }
    }

    public void startRegistActivity(View view){//跳转注册页面
        Intent intent=new Intent(this,RegistActivity.class);
        startActivity(intent);
        this.onPause();
    }

    public void l_reset(View view){//清空文本编辑框中的信息
        EditText editText_account=findViewById(R.id.login_editText_account);
        EditText editText_password=findViewById(R.id.login_editText_password);
        editText_account.setText("");
        editText_password.setText("");
        TextView alarm=findViewById(R.id.login_textView_alarm);
        alarm.setText("");//清空警示语
    }
}