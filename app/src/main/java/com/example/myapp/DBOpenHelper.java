package com.example.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {//SQLit数据库初始化
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists user_tb(_id integer primary key autoincrement,"+"userID text not null,"+"pwd text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
