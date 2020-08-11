package com.example.myandroidlearning.ActivityLifeCycleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class StandardStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Standard Activity", this.toString());
        setContentView(R.layout.activity_standard_start);
        Button button1 = (Button) findViewById(R.id.standard_start);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StandardStartActivity.this, StandardStartActivity.class);
                startActivity(intent);
            }
        });
    }
}