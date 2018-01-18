package com.example.student.dd2018011701;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.student.dd2018011701.data.Student;

public class DetailActivity extends AppCompatActivity {
    Student s;
    TextView tv4, tv5, tv6;
    int id;
    boolean fastback = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id = getIntent().getIntExtra("id", 0);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv5 = (TextView) findViewById(R.id.textView5);
        tv6 = (TextView) findViewById(R.id.textView6);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (fastback)
        {
            finish();
        }
        s = MainActivity.dao.getStudent(id);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
        builder.setTitle("刪除確認");
        builder.setMessage("確認要刪除本筆資料嗎");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.dao.delete(s.id);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void clickEdit(View v)
    {
        Intent it = new  Intent(DetailActivity.this, EditActivity.class);
        it.putExtra("id", s.id);
        fastback = true;
        startActivity(it);
    }
}
