package com.example.student.dd2018011701.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.student.dd2018011701.MainActivity;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/22.
 */

public class StudentDAODBImpl implements StudentDAO {
    Context context;
    SQLiteDatabase db;

    StudentDAODBImpl(Context context)
    {
        this.context = context;
        MyDBHelper helper = new MyDBHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public boolean add(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("_id", s.id);
        cv.put("name", s.name);
        cv.put("score", s.score);
        db.insert("students", null, cv);
        return false;
    }

    @Override
    public ArrayList<Student> getList() {
        ArrayList<Student> myList = new ArrayList<>();
        Cursor c = db.query("students", new String[] {"_id", "name", "score"}, null, null, null, null, null);
        if (c.moveToFirst())
        {
            Student s = new Student(c.getInt(0), c.getString(1), c.getInt(2));
            myList.add(s);
            while (c.moveToNext())
            {
                s = new Student(c.getInt(0), c.getString(1), c.getInt(2));
                myList.add(s);
            }
        }
        return myList;
    }

    @Override
    public Student getStudent(int id) {
        Cursor c = db.query("students", new String[] {"_id", "name", "score"}, "_id=?", new String[] {String.valueOf(id)}, null, null, null);
        if (c.moveToFirst())
        {
            Student s = new Student(c.getInt(0), c.getString(1), c.getInt(2));
            return s;
        }
        return null;
    }

    @Override
    public boolean update(Student student) {
        ContentValues cv = new ContentValues();
        cv.put("name", student.name);
        cv.put("score", student.score);
        db.update("students", cv, "_id=?", new String[] {String.valueOf(student.id)});
        return true;
    }

    @Override
    public boolean delete(int id) {
        db.delete("students", "_id=?", new String[] {String.valueOf(id)});
        return true;
    }
}
