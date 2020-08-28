package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);//切换使用动画
        setContentView(R.layout.activity_regist);
    }

    public void regist(View view){//注册操作
        EditText editText_account=findViewById(R.id.regist_editText_account);
        EditText editText_pwd=findViewById(R.id.regist_editText_password);
        EditText editText_pwd2=findViewById(R.id.regist_editText_password2);
        String name=editText_account.getText().toString();
        String pwd=editText_pwd.getText().toString();
        String pwd2=editText_pwd2.getText().toString();
        TextView alarm=findViewById(R.id.regist_textView_alarm);
        //清空警示语
        alarm.setText("");
        //调用dbopenhelp创建user表
        DBOpenHelper dbOpenHelper=new DBOpenHelper(this,"user.db",null,1);
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        //搜索用户名密码
        Cursor c=db.query("user_tb",null,"userID=?",new String[]{name},null,null,null);
        if(c!=null&&c.getCount()>1){//判断用户名是否存在
            alarm.setText("用户名存在");
            c.close();
        }else{
            if(pwd.equals(pwd2)){
                if(name.equals("")){
                    alarm.setText("请输入用户名");
                }else{
                    ContentValues values=new ContentValues();
                    values.put("userID",name);
                    values.put("pwd",pwd);
                    long rows=db.insert("user_tb",null,values);
                    //跳转至login页面
                    Intent intent=new Intent(this,LoginActivity.class);
                    startActivity(intent);
                    this.finish();
                }
            }else{
                alarm.setText("两次密码不一致");
            }
        }
        c.close();
        db.close();
    }

    public void r_reset(View view){//清空文本编辑框中的信息
        EditText editText_account=findViewById(R.id.regist_editText_account);
        EditText editText_password=findViewById(R.id.regist_editText_password);
        EditText editText_password2=findViewById(R.id.regist_editText_password2);
        editText_account.setText("");
        editText_password.setText("");
        editText_password2.setText("");
        TextView alarm=findViewById(R.id.regist_textView_alarm);
        alarm.setText("");//清空警示语
    }
}