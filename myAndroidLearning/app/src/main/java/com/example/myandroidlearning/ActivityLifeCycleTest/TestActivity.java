package com.example.myandroidlearning.ActivityLifeCycleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", this.toString());
        Log.d("FirstActivity", "Task id is " + getTaskId());
        setContentView(R.layout.activity_first);
        Button button1 = (Button) findViewById(R.id.BackToSingleTop);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.BackToSingle);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, SingleTaskActivtity.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.back_to_instance);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FirstActivity", "onDestory");
    }
}