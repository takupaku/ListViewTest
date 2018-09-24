package com.example.student.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    String div;
    TextView title,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
        initVariable();
        displayData();
    }

    private void displayData() {
        if(div.equalsIgnoreCase("dhaka")){
            title.setText(div);
            String det = getResources().getString(R.string.dhaka);
            detail.setText(det);

        }
    }


    private void initView() {
        setContentView(R.layout.activity_info);
        title =findViewById(R.id.titleId);
        detail = findViewById(R.id.detailId);
    }

    private void initVariable() {
      Bundle bundle = getIntent().getExtras();

      if(bundle != null)
      div = bundle.getString("division");
      else {
          div = "default";
      }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
