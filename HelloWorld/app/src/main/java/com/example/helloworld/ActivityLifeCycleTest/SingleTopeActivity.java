package com.example.helloworld.ActivityLifeCycleTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.helloworld.R;

public class SingleTopeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_tope);
    }
}