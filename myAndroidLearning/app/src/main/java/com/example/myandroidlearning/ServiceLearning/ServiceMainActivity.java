package com.example.myandroidlearning.ServiceLearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
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

public class ServiceMainActivity extends AppCompatActivity implements ServiceConnection {
    private Button startServiceBtn,stopServiceBtn, bindServiceBtn, unBindServiceBtn,downLoaderBtn, synDataBtn, startIntentServiceBtn;
    private EditText etData;
    private TextView tvOut;
    private MyService.myBlinder mBlinder;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            tvOut.setText(msg.getData().toString());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        startServiceBtn = (Button) findViewById(R.id.start_service_btn);
        stopServiceBtn = (Button) findViewById(R.id.stop_service_btn);
        bindServiceBtn = (Button) findViewById(R.id.bind_service_btn);
        unBindServiceBtn = (Button) findViewById(R.id.unbind_service_btn);
        etData = (EditText) findViewById(R.id.service_etdata);
        downLoaderBtn = (Button) findViewById(R.id.downLoader_btn);
        synDataBtn = (Button) findViewById(R.id.syn_data_btn);
        tvOut = (TextView) findViewById(R.id.service_tvOut);
        startIntentServiceBtn = (Button) findViewById(R.id.start_intent_service_btn);
        setOnclickListener();
    }

    private void setOnclickListener(){
        OnClick onclick = new OnClick();
        startServiceBtn.setOnClickListener(onclick);
        stopServiceBtn.setOnClickListener(onclick);
        bindServiceBtn.setOnClickListener(onclick);
        unBindServiceBtn.setOnClickListener(onclick);
        downLoaderBtn.setOnClickListener(onclick);
        synDataBtn.setOnClickListener(onclick);
        startIntentServiceBtn.setOnClickListener(onclick);
    }
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            Intent serviceIntent = new Intent(ServiceMainActivity.this, MyService.class);
            switch (view.getId()){
                case R.id.update_UI_btn:
                    Toast.makeText(getApplicationContext(), "跳转到List View 页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ServiceMainActivity.this, UpdateUIActivity.class);
                    break;
                case R.id.start_service_btn:
                    Toast.makeText(getApplicationContext(), "启动服务",Toast.LENGTH_SHORT).show();
                    serviceIntent.putExtra("etData",etData.getText().toString());
                    startService(serviceIntent);
                    break;
                case R.id.stop_service_btn:
                    Toast.makeText(getApplicationContext(), "停止服务",Toast.LENGTH_SHORT).show();
                    stopService(serviceIntent);
                    break;
                case R.id.bind_service_btn:
                    Toast.makeText(getApplicationContext(), "绑定服务",Toast.LENGTH_SHORT).show();
                    bindService(serviceIntent, ServiceMainActivity.this, Context.BIND_AUTO_CREATE);
                    break;
                case R.id.unbind_service_btn:
                    Toast.makeText(getApplicationContext(), "解绑服务",Toast.LENGTH_SHORT).show();
                    unbindService(ServiceMainActivity.this);
                    break;
                case R.id.downLoader_btn:
                    Toast.makeText(getApplicationContext(), "跳转到下载Service",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ServiceMainActivity.this, DownLoadMainActivity.class);
                    break;
                case R.id.syn_data_btn:
                    Toast.makeText(getApplicationContext(), "同步数据",Toast.LENGTH_SHORT).show();
                    if(mBlinder != null){
                        mBlinder.setData(etData.getText().toString());
                    }
                    break;
                case R.id.start_intent_service_btn:
                    Toast.makeText(getApplicationContext(), "跳转到IntentService",Toast.LENGTH_SHORT).show();
                    Log.d("ServiceMainActivity","Thread id is " + Thread.currentThread().getId());
                    Intent intentService = new Intent(ServiceMainActivity.this, MyIntentService.class);
                    startService(intentService);
                    break;
                default:
                    break;
            }
            if(intent != null){
                startActivity(intent);
            }
        }
    }
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("onServiceConnected","Service connected......");
        mBlinder = (MyService.myBlinder) iBinder;
        mBlinder.getMyService().setCallBack(new MyService.CallBack() {
            @Override
            public void onDataChange(String data) {
                //tvOut.setText(data); 直接赋值会出错,更新UI只能在主线程
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data",data);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("onServiceDisconnected","Service disconnected......");
    }
}