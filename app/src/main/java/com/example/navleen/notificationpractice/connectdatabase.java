package com.example.navleen.notificationpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class connectdatabase extends SQLiteOpenHelper {

    public final static String DB_Name="communicationmedia";
    public final static int DB_Version=1;

    public final static String T_Name="login";
    public final static String c_username="username";
    public final static String c_password="password";
    public final static String QUERY="create table "+T_Name+"("+c_username+" text,"+c_password+" text)";


    public final static String Ta_Name="sender";
    public final static String c_senedername="sendername";
    public final static String c_msg="msg";
    public final static String quer="create table "+Ta_Name+"("+c_senedername+" text,"+c_msg+" text)";


    public connectdatabase(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY);
        db.execSQL(quer);
        SQLiteDatabase d=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(c_username,"Navneel");
        cv.put(c_password,"admin");
        long c=db.insert(T_Name,null,cv);
        if(c>0)
        {
            Log.d("add","inserted");
        }
        else {
            Log.d("add","not inserted");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
