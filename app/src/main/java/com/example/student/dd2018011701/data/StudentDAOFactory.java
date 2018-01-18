package com.example.student.dd2018011701.data;

import android.content.Context;

/**
 * Created by Student on 2018/1/18.
 */

public class StudentDAOFactory {
    public static StudentDAO getDAOInstance(Context context, int dbType)
    {
        switch (dbType)
        {
            case 1:
                return new StudentScoreDAO();
            case 2:
                return  new StudentFileDAO(context);
        }
        return null;
    }
}
