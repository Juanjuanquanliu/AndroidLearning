package com.example.myandroidlearning.ServiceLearning.MultiThreading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myandroidlearning.R;

public class UpdateUIActivity extends AppCompatActivity {
    public static final int UPDATE_TEXT = 1;
    private TextView tx;
    private Button btn;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case UPDATE_TEXT:
                    tx.setText(" Nice to meet you");
                    break;
                default:
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ui);
        tx = (TextView) findViewById(R.id.update_ui_tv);

        btn = (Button) findViewById(R.id.update_ui_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //tx.setText("Nice to meet you");//不可以在子线程中更新UI，会崩溃
                        //异步消息处理
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);//将Message发送出去
                    }
                }).start();

            }
        });

    }
}