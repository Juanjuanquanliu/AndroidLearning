package com.example.myandroidlearning.ActivityLifeCycleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class SingleTaskActivtity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SingleTaskActivtity", "Task id is " + getTaskId());
        setContentView(R.layout.activity_single_task_activtity);
        Button button1 = (Button) findViewById(R.id.single_task);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleTaskActivtity.this, TestActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.single_instance);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleTaskActivtity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SingleTaskActivtity", "OnRestart");
    }
}