package com.example.student.dd2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.dd2018011701.data.Student;

public class EditActivity extends AppCompatActivity {
    EditText et4, et5;
    TextView tv7;
    Student s;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        tv7 = findViewById(R.id.textView7);
        et4 = findViewById(R.id.editText4);
        et5 = findViewById(R.id.editText5);
        id = getIntent().getIntExtra("id", 0);
        s = MainActivity.dao.getStudent(id);

        tv7.setText(String.valueOf(s.id));
        et4.setText(s.name);
        et5.setText(String.valueOf(s.score));
    }

    public void clickBack(View v)
    {
        finish();
    }

    public void clickUpdate(View v)
    {
        Student s = new Student(id, et4.getText().toString(), Integer.valueOf(et5.getText().toString()));
        MainActivity.dao.update(s);
        finish();
    }
}
