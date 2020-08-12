package com.example.myandroidlearning.Views.ListView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class ListViewButtonsActivity extends Activity {
    private Button simple_list_view_btn, fruit_list_view_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_buttons);
        simple_list_view_btn = (Button) findViewById(R.id.simple_list_view_btn);
        fruit_list_view_btn = (Button) findViewById(R.id.fruit_list_view_btn);
        simple_list_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListViewButtonsActivity.this, SimpleListViewActivity.class);
                startActivity(intent);
            }
        });
        fruit_list_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListViewButtonsActivity.this, FruitListViewActivity.class);
                startActivity(intent);
            }
        });

    }
}