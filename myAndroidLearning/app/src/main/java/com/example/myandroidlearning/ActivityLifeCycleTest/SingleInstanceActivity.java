package com.example.myandroidlearning.ActivityLifeCycleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class SingleInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SingleInstanceActivtity", "Task id is " + getTaskId());
        setContentView(R.layout.activity_single_instance);
        Button button1 = (Button) findViewById(R.id.single_instance);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleInstanceActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }
}