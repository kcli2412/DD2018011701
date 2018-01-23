package com.example.student.dd2018011701.data;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */

public class StudentCloudDAO implements StudentDAO {
    Context context;
    ArrayList<Student> mylist;

    FirebaseDatabase database;
    DatabaseReference myRef;

    public StudentCloudDAO(Context context)
    {
        this.context = context;

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("scores");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                mylist = gson.fromJson(value, new TypeToken<ArrayList<Student>>(){}.getType());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
            }
        });

        if (mylist == null)
        {
            mylist = new ArrayList<>();
        }
    }

    private void saveFile()
    {
        // Write a message to the database
        Gson gson = new Gson();
        String data = gson.toJson(mylist);

        myRef.setValue(data);
        Log.d("SAVE", "saveFile: ");
    }

    public boolean add(Student s)
    {
        if (mylist == null)
        {
            mylist = new ArrayList<>();
        }
        mylist.add(s);
        saveFile();
        return true;
    }

    public ArrayList<Student> getList()
    {
        return mylist;
    }

    public Student getStudent(int id)
    {
        for (Student s:mylist)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }

    public boolean update(Student student)
    {
        for (Student s:mylist)
        {
            if (s.id == student.id)
            {
                s.name = student.name;
                s.score = student.score;
                saveFile();
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id)
    {
        for (Student s:mylist)
        {
            if (s.id == id)
            {
                mylist.remove(s);
                saveFile();
                return true;
            }
        }
        return false;
    }
}
