package com.example.myandroidlearning.ServiceLearning.DownLoadTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myandroidlearning.R;


public class DownLoadMainActivity extends AppCompatActivity implements ServiceConnection, View.OnClickListener {
    private Button startDownload, pauseDownload, cancelDownload;
    private DownLoadService.DownLoadBinder downLoadBinder;
    private EditText etData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader_main);
        startDownload = (Button) findViewById(R.id.start_download);
        pauseDownload = (Button) findViewById(R.id.pause_download);
        cancelDownload = (Button) findViewById(R.id.cancel_download);

        Log.d("DownLoadMainActivity", "downLoadBinder:" + downLoadBinder);
        setOnclickListener();
        Intent intent = new Intent(this, DownLoadService.class);
        startService(intent);
        bindService(intent, DownLoadMainActivity.this, Context.BIND_AUTO_CREATE);
//        if(ContextCompat.checkSelfPermission(DownLoadMainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(DownLoadMainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this);
    }

    private void setOnclickListener(){
        startDownload.setOnClickListener(this);
        pauseDownload.setOnClickListener(this);
        cancelDownload.setOnClickListener(this);
    }
        @Override
        public void onClick(View view) {
            if(downLoadBinder == null)return;
            switch (view.getId()) {
                case R.id.start_download:
                    String url = "http://down.shouji.kuwo.cn/star/mobile/kwplayer_ar_pcguanwangmobile.apk";//"https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe";
                    Log.d("DownLoadMainActivity", url);
                    downLoadBinder.startDownload(url);
                    break;
                case R.id.pause_download:
                    downLoadBinder.pauseDownload();
                    break;
                case R.id.cancel_download:
                    downLoadBinder.cancleDownload();
                    break;
                default:
                    break;
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "拒绝权限将无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        downLoadBinder = (DownLoadService.DownLoadBinder) iBinder;
        Log.d("DownLoadMainActivity", "downLoadBinder:" + downLoadBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
    }
}