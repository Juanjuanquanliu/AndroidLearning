package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressDialogActivity extends AppCompatActivity {
    private Button Login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        Login_btn = (Button) findViewById(R.id.log_in_btn);

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressDialogActivity.this);
                progressDialog.setTitle("登录中");
                progressDialog.setMessage("Loading......");
                progressDialog.show();
            }
        });
    }
}