package com.example.myandroidlearning.ServiceLearning.DownLoadTask;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.webkit.DownloadListener;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.ServiceLearning.ServiceMainActivity;

import java.io.File;

public class DownLoadService extends Service {

    public DownLoadService() {
    }

    private DownLoadBinder myBinder = new DownLoadBinder();

    private String downloadUrl;

    private DownLoadTask downLoadTask;

    private DownLoadListener downloadListener = new DownLoadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1, getNotification("Downloading......", progress));
        }

        @Override
        public void onSuccess() {
            downLoadTask = null;
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("Download Success", -1));
            Toast.makeText(DownLoadService.this, "Download Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailed() {
            downLoadTask = null;
            stopForeground(true);
            getNotificationManager().notify(1, getNotification("Downloading Failed", -1));
            Toast.makeText(DownLoadService.this, "Download Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            downLoadTask = null;
            Toast.makeText(DownLoadService.this, "Download Paused", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            downLoadTask = null;
            stopForeground(true);
            Toast.makeText(DownLoadService.this, "Download Canceled", Toast.LENGTH_SHORT).show();
        }
    };
    class DownLoadBinder extends Binder{
        public DownLoadBinder(){
            super();
        }
        public void startDownload(String url){
            Log.d("MyService","startDownload executed");
            if(downLoadTask == null){
                downloadUrl = url;
                downLoadTask = new DownLoadTask(downloadListener);
                downLoadTask.execute(downloadUrl);
                startForeground(1,getNotification("Downloading...",0));
                Toast.makeText(DownLoadService.this, "Downloading......", Toast.LENGTH_SHORT).show();
            }
        }
        public void pauseDownload(){
            if(downLoadTask != null){
                downLoadTask.pauseDownload();
            }
        }
        public void cancleDownload(){
            if(downLoadTask != null){
                downLoadTask.CanceleDownload();
            }
            if(downloadUrl != null){
                String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                File file = new File(directory + fileName);
                if(file.exists()){
                    file.delete();
                }
                getNotificationManager().cancel(1);
                stopForeground(true);
                Toast.makeText(DownLoadService.this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }

        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    private NotificationManager getNotificationManager(){
        return (NotificationManager)(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    private Notification getNotification(String title, int progress){
        String CHANNEL_ONE_ID = "CHANNEL_ONE_ID";
        String CHANNEL_ONE_NAME= "CHANNEL_ONE_ID";
        NotificationChannel notificationChannel= null;
        //进行8.0的判断
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel= new NotificationChannel(CHANNEL_ONE_ID,
                    CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
        }
        Intent intent = new Intent(this, ServiceMainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setChannelId(CHANNEL_ONE_ID)
                .setContentTitle(title)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi);

        if(progress >= 0){
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }

        return builder.build();
    }
}
