package com.example.anotherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myandroidlearning.ServiceLearning.Service_AIDL.IMyAidlService;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    private Button startServiceBtn,stopServiceBtn,bindServiceBtn,unbindServiceBtn,syncDataBtn;
    private Intent serviceIntent;
    private EditText etData;
    private IMyAidlService binder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.myandroidlearning","com.example.myandroidlearning.ServiceLearning.Service_AIDL.MyAIDLService"));
        //startService(new Intent(MainActivity.this, AnotherMyService.class));
        startServiceBtn = (Button) findViewById(R.id.start_anotherApp_service_btn);
        stopServiceBtn = (Button) findViewById(R.id.stop_anotherApp_service_btn);
        bindServiceBtn = (Button) findViewById(R.id.bind_anotherApp_service_btn);
        unbindServiceBtn = (Button) findViewById(R.id.unbind_anotherApp_service_btn);
        syncDataBtn =  (Button) findViewById(R.id.sync_data_btn);
        etData = (EditText) findViewById(R.id.etData);
        setOnclickListener();
    }

    private void setOnclickListener(){
        OnClick onclick = new OnClick();
        startServiceBtn.setOnClickListener(onclick);
        stopServiceBtn.setOnClickListener(onclick);
        bindServiceBtn.setOnClickListener(onclick);
        unbindServiceBtn.setOnClickListener(onclick);
        syncDataBtn.setOnClickListener(onclick);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("BindService",iBinder.toString());
        binder = IMyAidlService.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        stopService(new Intent(MainActivity.this, AnotherMyService.class));
        Log.d("unBindService","onDestorying......");
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start_anotherApp_service_btn:
                    startService(serviceIntent);
                    break;
                case R.id.stop_anotherApp_service_btn:
                    stopService(serviceIntent);
                    break;
                case R.id.bind_anotherApp_service_btn:
                    bindService(serviceIntent,MainActivity.this, Context.BIND_AUTO_CREATE);
                    break;
                case R.id.unbind_anotherApp_service_btn:
                    unbindService(MainActivity.this);
                    binder = null;
                    break;
                case R.id.sync_data_btn:
                    if(binder!=null){
                        try{
                            binder.setData(etData.getText().toString());
                        }catch (RemoteException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //stopService(new Intent(MainActivity.this, AnotherMyService.class));
    }
}
