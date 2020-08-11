package com.example.myandroidlearning.ActivityLifeCycleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class SingleTopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SingleTopActivity", this.toString());
        setContentView(R.layout.activity_single_top);
        Button button1 = (Button) findViewById(R.id.single_top);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleTopActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }
}