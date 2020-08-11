package com.example.myandroidlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity {
    private ProgressBar pb_hor, my_pb;
    private Button Login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb_hor = (ProgressBar) findViewById(R.id.progress_bar_hor);
        my_pb =  (ProgressBar) findViewById(R.id.my_progress_bar);
        Login_btn = (Button) findViewById(R.id.log_in_btn);
        pb_hor.setProgress(5);
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb_hor.setVisibility(View.VISIBLE);
                my_pb.setVisibility(View.VISIBLE);
                handler.sendEmptyMessage(0);
            }
        });
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(pb_hor.getProgress() < 100){
                handler.postDelayed(runnable, 500);
            }else{
                pb_hor.setVisibility(View.GONE);
                my_pb.setVisibility(View.GONE);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ProgressBarActivity.this);
                alertBuilder.setTitle("登陆信息").setCancelable(false).setMessage("登陆成功").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_LONG).show();
                    }
                }).show();

            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            pb_hor.setProgress(pb_hor.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}