package com.example.myandroidlearning.ServiceLearning;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.core.app.NotificationCompat;

import com.example.myandroidlearning.MainActivity;
import com.example.myandroidlearning.R;

public class MyService extends Service {
    private boolean serviceRunning = false;
    private String myData = "这是默认信息";
    private CallBack callBack = null;

    public CallBack getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new myBlinder();
    }
    class myBlinder extends Binder{
        public void setData(String data){
            myData = data;
        }
        public MyService getMyService(){
            return MyService.this;
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        serviceRunning = true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(serviceRunning){
                    Log.d("Service onStartCommand","Service is running  ......");
                    try{
                        sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        }.start();

        //myData = intent.getStringExtra("etData");
        //Log.d("Service onStartCommand","Service is running  ......\t EditTextData：" + myData);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        super.onCreate();
//        serviceRunning = true;
        Log.d("Service onCreate","Service created.....");
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                int i = 0;
//                while(serviceRunning){
//                    i++;
//                    try{
//                        String str = "Service is running  ......\t"+ i + " EditTextData：" + myData;
//                        Log.d("Service onCreate",str);
//                        if(callBack != null){
//                            callBack.onDataChange(str);
//                        }
//                        sleep(1000);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
        String CHANNEL_ONE_ID = "CHANNEL_ONE_ID";
        String CHANNEL_ONE_NAME= "CHANNEL_ONE_ID";
        NotificationChannel notificationChannel= null;
//进行8.0的判断
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel= new NotificationChannel(CHANNEL_ONE_ID,
                    CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH);
//            notificationChannel.enableLights(true);
//            notificationChannel.setLightColor(Color.RED);
//            notificationChannel.setShowBadge(true);
//            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
        }
        Intent intent = new Intent(this, ServiceMainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setChannelId(CHANNEL_ONE_ID)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        notification.flags|= Notification.FLAG_NO_CLEAR;
        startForeground(1, notification);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        serviceRunning = false;
        Log.d("Service onDestroy","Service destroied.....");
    }


    public static interface CallBack{
        void onDataChange(String data);
    }
}
