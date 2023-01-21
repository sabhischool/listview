package com.example.searchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Employee> emp_list;
    LayoutInflater linf=null;
    EmployeeHolder holder=null;






    public EmployeeAdapter(Context ctx, ArrayList<Employee> emp_list) {
        super();
        this.ctx = ctx;
        this.emp_list = emp_list;
        linf=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class EmployeeHolder
    {
        TextView name;
        TextView age;

    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return emp_list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return emp_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView==null)
        {
            convertView=linf.inflate(R.layout.row, parent, false);
            holder=new EmployeeHolder();
            holder.name=(TextView) convertView.findViewById(R.id.name);
            holder.age=(TextView) convertView.findViewById(R.id.age);

            convertView.setTag(holder);
        }
        else
        {
            holder=(EmployeeHolder) convertView.getTag();
        }

        Employee e=(Employee) getItem(position);


        holder.name.setText(e.getName());
        holder.age.setText(String.valueOf(e.getAge()));

        return convertView;

    }

}
