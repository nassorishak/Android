package com.example.androidd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText code;
    private EditText name;
    private CourseDBManager courseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        code=(EditText) findViewById(R.id.txtCode);
        name=(EditText) findViewById(R.id.txtName);
        courseDB=new CourseDBManager(this);
        courseDB.openConnection();
    }
    public void saveCourse(View v){
        String cd=code.getText().toString();
        String nm=name.getText().toString();
        courseDB.inserCourse(cd,nm);
        Toast.makeText(this,"Course has beed created successfully.",Toast.LENGTH_LONG).show();
    }
    public void getCourse(View v){
        Cursor cursor=courseDB.getCcourses();
        while(cursor.moveToNext()){
            Toast.makeText(this,"code: "+cursor.getString(0)+", name: "+cursor.getString(1),Toast.LENGTH_LONG).show();
        }
    }
}