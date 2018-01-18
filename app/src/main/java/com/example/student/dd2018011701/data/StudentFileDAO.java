package com.example.student.dd2018011701.data;

import android.content.Context;

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

public class StudentFileDAO {
    Context context;
    ArrayList<Student> mylist;

    public StudentFileDAO(Context context)
    {
        this.context = context;
        mylist = new ArrayList<>();
    }

    private void saveFile()
    {
        File f = new File(context.getFilesDir(), "mydata.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load()
    {
        File f = new File(context.getFilesDir(), "mydata.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Gson gson = new Gson();
            mylist = gson.fromJson(str, new TypeToken<ArrayList<Student>>(){}.getType());
            br.close();;
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Student s)
    {
        mylist.add(s);
        saveFile();
        return true;
    }

    public ArrayList<Student> getList()
    {
        load();
        return mylist;
    }

    public Student getStudent(int id)
    {
        load();
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
        load();
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
        load();
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
