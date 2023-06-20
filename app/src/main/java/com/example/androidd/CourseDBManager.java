package com.example.androidd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CourseDBManager {
    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    public CourseDBManager(Context context){
        this.context=context;
    }

    public CourseDBManager openConnection(){
        dbHelper=new DBHelper(context);
        db=dbHelper.getWritableDatabase();
        return this;
    }
    public void closeConnection(){
        dbHelper.close();
    }

    public void inserCourse(String code, String name){
        ContentValues values=new ContentValues();
        values.put("code",code);
        values.put("courseName",name);
        db.insert("courses","",values);
    }

    public Cursor getCcourses(){
        String[] cols=new String[]{"code","courseName"};
        Cursor cursor=db.query("courses",cols,null,null,null,null,null);
//        if(cursor!=null){
//            cursor.moveToFirst();
//        }
        return cursor;
    }

}
