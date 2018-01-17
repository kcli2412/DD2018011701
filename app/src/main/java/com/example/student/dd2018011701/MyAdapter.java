package com.example.student.dd2018011701;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.student.dd2018011701.data.Student;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> mylist = new ArrayList<>();

    MyAdapter(Context context, ArrayList<Student> mylist)
    {
        this.context = context;
        this.mylist = mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.myitem, null);
            viewHolder = new ViewHolder();
            viewHolder.tv1 = (TextView) view.findViewById(R.id.textView);
            viewHolder.tv2 = (TextView) view.findViewById(R.id.textView2);
            viewHolder.tv3 = (TextView) view.findViewById(R.id.textView3);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv1.setText(String.valueOf(mylist.get(i).id));
        viewHolder.tv2.setText(mylist.get(i).name);
        viewHolder.tv3.setText(String.valueOf(mylist.get(i).score));

        return view;
    }

    static class ViewHolder
    {
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }
}
