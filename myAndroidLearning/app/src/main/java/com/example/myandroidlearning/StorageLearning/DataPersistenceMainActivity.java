package com.example.myandroidlearning.StorageLearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

import java.io.BufferedReader;

public class DataPersistenceMainActivity extends AppCompatActivity {
    private Button fileTestBtn,sharePreferencesTestBtn, sharePreferencesLoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_persistence_main);
        fileTestBtn = (Button) findViewById(R.id.file_test_btn);
        sharePreferencesTestBtn = (Button) findViewById(R.id.share_preferences_test_btn);
        sharePreferencesLoginBtn = (Button)findViewById(R.id.share_preferences_login_btn);
        fileTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPersistenceMainActivity.this, FilePesistenceTestActivity.class);
                startActivity(intent);
            }
        });
        sharePreferencesTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPersistenceMainActivity.this, SharePreferencesActivity.class);
                startActivity(intent);
            }
        });
        sharePreferencesLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataPersistenceMainActivity.this, StorageLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}