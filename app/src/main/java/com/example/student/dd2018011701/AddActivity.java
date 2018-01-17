package com.example.student.dd2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.dd2018011701.data.Student;

import static com.example.student.dd2018011701.MainActivity.dao;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void clickAdd(View v)
    {
        EditText et1 = (EditText) findViewById(R.id.editText);
        EditText et2 = (EditText) findViewById(R.id.editText2);
        EditText et13 = (EditText) findViewById(R.id.editText3);
        int id = Integer.valueOf(et1.getText().toString());
        String name = et2.getText().toString();
        int score = Integer.valueOf(et13.getText().toString());
        dao.add(new Student(id, name, score));
        finish();
    }
}
