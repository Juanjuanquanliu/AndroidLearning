package com.example.myandroidlearning;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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