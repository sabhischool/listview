package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends Activity implements SearchView.OnQueryTextListener  {
    SearchView mSearchView;
    ListView mListView;
    //String mStrings[]= {"abc","def","efg","ghi","ijk","apple","agxhsdgc","abbbcc"};
    ArrayList<Employee> emp_list=null;
    EmployeeAdapter emp_adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchView=(SearchView) findViewById(R.id.searchView1);
        mListView=(ListView) findViewById(R.id.listView1);

        emp_list=new ArrayList<Employee>();
        emp_list.add(new Employee("ABC", 24));
        emp_list.add(new Employee("ACB", 24));
        emp_list.add(new Employee("BVF", 28));
        emp_list.add(new Employee("BRT", 28));
        emp_list.add(new Employee("ANM", 23));

        emp_adapter=new EmployeeAdapter(MainActivity.this, emp_list);
        mListView.setAdapter(emp_adapter);

//      mListView.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                mStrings));
        mListView.setTextFilterEnabled(true);
        setupSearchView();

    }
    private void setupSearchView()
    {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Search Here");
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
       return false;
    }

    @Override
    public boolean onQueryTextChange(String newText ) {
        if (TextUtils.isEmpty(newText.toString())) {
            mListView.clearTextFilter();
        } else {
            mListView.setFilterText(newText.toString());
        }
        return true;
    }
}