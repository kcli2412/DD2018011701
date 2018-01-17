package com.example.student.dd2018011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.student.dd2018011701.data.Student;

public class DetailActivity extends AppCompatActivity {
    Student s;
    TextView tv4, tv5, tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("id", 0);
        s = MainActivity.dao.getStudent(id);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv5 = (TextView) findViewById(R.id.textView5);
        tv6 = (TextView) findViewById(R.id.textView6);
        tv4.setText(String.valueOf(s.id));
        tv5.setText(s.name);
        tv6.setText(String.valueOf(s.score));
    }
}
