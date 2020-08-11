package com.example.myandroidlearning.ActivityLifeCycleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class ActivityLifeCycleTestButtons extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_test_buttons);
        Button button1 = (Button) findViewById(R.id.standard_start_btn);
        Button button2 = (Button) findViewById(R.id.single_top_btn);
        Button button3 = (Button) findViewById(R.id.single_task_btn);
        Button button4 = (Button) findViewById(R.id.single_instance_btn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ActivityLifeCycleTestButtons.this, StandardStartActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ActivityLifeCycleTestButtons.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ActivityLifeCycleTestButtons.this, SingleTaskActivtity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ActivityLifeCycleTestButtons.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });

    }
}