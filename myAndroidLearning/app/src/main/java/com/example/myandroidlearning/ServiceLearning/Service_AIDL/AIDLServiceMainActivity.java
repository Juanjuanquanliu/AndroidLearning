package com.example.myandroidlearning.ServiceLearning.Service_AIDL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.ServiceLearning.DownLoadTask.DownLoadMainActivity;
import com.example.myandroidlearning.ServiceLearning.MultiThreading.UpdateUIActivity;
import com.example.myandroidlearning.ServiceLearning.MyIntentService;
import com.example.myandroidlearning.ServiceLearning.MyService;
import com.example.myandroidlearning.ServiceLearning.ServiceMainActivity;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class AIDLServiceMainActivity extends AppCompatActivity {
    private Button startServiceBtn,stopServiceBtn;
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.anotherapp","com.example.anotherapp.AnotherMyService"));
        setContentView(R.layout.activity_aidl_service_main);
        startServiceBtn = (Button) findViewById(R.id.start_anotherApp_service_btn);
        stopServiceBtn = (Button) findViewById(R.id.stop_anotherApp_service_btn);
        //startService(new Intent(AIDLServiceMainActivity.this, MyAIDLService.class));
        setOnclickListener();
    }

    private void setOnclickListener(){
        OnClick onclick = new OnClick();
        startServiceBtn.setOnClickListener(onclick);
        stopServiceBtn.setOnClickListener(onclick);
    }
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.start_anotherApp_service_btn:
                    startService(serviceIntent);
                    break;
                case R.id.stop_anotherApp_service_btn:
                    stopService(serviceIntent);
                    break;
                default:
                    break;
            }
        }
    }

}