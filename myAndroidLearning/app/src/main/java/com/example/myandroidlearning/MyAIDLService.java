package com.example.myandroidlearning;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.myandroidlearning.ServiceLearning.Service_AIDL.IMyAidlService;

public class MyAIDLService extends Service {
    public MyAIDLService() {
    }
    private String data = "默认数据";
    private boolean isRunning = false;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new IMyAidlService.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void setData(String data) throws RemoteException {
                MyAIDLService.this.data = data;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                while(isRunning);{
                    Log.d("MyAIDLService"," transfer data "+data);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        Log.d("MyAIDLService","onCreating......");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyAIDLService","onStartCommand......");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        Log.d("MyAIDLService","onDestorying......");
    }
}
