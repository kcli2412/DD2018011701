package com.example.student.dd2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.student.dd2018011701.data.Student;

public class DetailActivity extends AppCompatActivity {
    Student s;
    TextView tv4, tv5, tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onResume() {
        super.onResume();

        int id = getIntent().getIntExtra("id", 0);
        s = MainActivity.dao.getStudent(id);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv5 = (TextView) findViewById(R.id.textView5);
        tv6 = (TextView) findViewById(R.id.textView6);
        tv4.setText(String.valueOf(s.id));
        tv5.setText(s.name);
        tv6.setText(String.valueOf(s.score));
    }

    public void clickBack(View v)
    {
        finish();
    }

    public void clickDelete(View v)
    {
        for (Student student:MainActivity.dao.getList())
        {
            if (student.id == s.id)
            {
                MainActivity.dao.delete(s.id);
                finish();
                return;
            }
        }
    }

    public void clickEdit(View v)
    {
        Intent it = new  Intent(DetailActivity.this, UpdateActivity.class);
        it.putExtra("id", s.id);
        startActivity(it);
    }
}
