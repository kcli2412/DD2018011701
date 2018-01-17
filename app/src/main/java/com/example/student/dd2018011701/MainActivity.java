package com.example.student.dd2018011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.dd2018011701.data.Student;
import com.example.student.dd2018011701.data.StudentScoreDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final public static StudentScoreDAO dao = new StudentScoreDAO();
    ListView lv;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lv = (ListView) findViewById(R.id.listView);
        ArrayList<String> studentNames = new ArrayList<>();
        for (Student s:dao.getList())
        {
            studentNames.add(s.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, studentNames);
        lv.setAdapter(adapter);
        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                startActivity(it);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        myAdapter = new MyAdapter(MainActivity.this, dao.getList());
//        lv.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.main_add:
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                startActivity(it);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
