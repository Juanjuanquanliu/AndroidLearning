package com.example.myandroidlearning.BroadCastLearning.ForceOffline;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver forceOfflineReceiver;

    public LocalBroadcastManager getLocalBroadcastManager() {
        return localBroadcastManager;
    }

    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcast.FORCE_OFFLINE");
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        forceOfflineReceiver = new ForceOfflineReceiver(this);
        localBroadcastManager.registerReceiver(forceOfflineReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(forceOfflineReceiver!=null){
            localBroadcastManager.unregisterReceiver(forceOfflineReceiver);
            forceOfflineReceiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
