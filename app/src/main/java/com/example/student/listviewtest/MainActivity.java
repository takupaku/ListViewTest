package com.example.student.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SearchView searchView;

    private String[] divisions={"dhaka"," khulna"," chittagong","sylet", "rajshahi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


        initFunctionality();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewId);
        searchView= findViewById(R.id.searchViewId);
        setTitle("Division");
    }

    private void initFunctionality() {
        final ArrayAdapter adapter = new ArrayAdapter(this,R.layout.sample_layout,R.id.itemId,getResources().getStringArray(R.array.countries_array));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String div= divisions[i];
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("divisions",div);
                startActivity(intent);
               // Toast.makeText(MainActivity.this, "" +div, Toast.LENGTH_SHORT).show();

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);

                return false;
            }
        });
    }
}
