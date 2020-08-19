package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myandroidlearning.ActivityLifeCycleTest.ActivityLifeCycleTestButtons;
import com.example.myandroidlearning.BroadCastLearning.BroadCastMainActivity;
import com.example.myandroidlearning.BroadCastLearning.ForceOffline.BaseActivity;
import com.example.myandroidlearning.BroadCastLearning.ForceOffline.ForceOfflineReceiver;
import com.example.myandroidlearning.DIY.DIYActivity;
import com.example.myandroidlearning.Fragment.NewsFragment.NewsMainActivity;
import com.example.myandroidlearning.ServiceLearning.MultiThreading.UpdateUIActivity;
import com.example.myandroidlearning.ServiceLearning.ServiceMainActivity;
import com.example.myandroidlearning.StorageLearning.DataPersistenceMainActivity;
import com.example.myandroidlearning.StorageLearning.FilePesistenceTestActivity;
import com.example.myandroidlearning.Views.ListView.ListViewButtonsActivity;
import com.example.myandroidlearning.Views.RecyclerView.RecylerViewButtonsActivity;

public class MainActivity extends BaseActivity {
    private Button normal, dialog,progressBarBtn, progressDialogBtn,startModleBtn,diyTitleBtn, popBtn,listViewBtn,myFragmentBtn, recyclerViewBtn,sendOfflineBtn;
    private Button updateUIBtn,jump_to_service_btn,jump_to_boradcast_btn, storage_persistence_btn;

    private ForceOfflineReceiver forceOfflineReceiver;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);

        normal = (Button) findViewById(R.id.na_btn);
        dialog =  (Button) findViewById(R.id.dial_btn);
        progressBarBtn = (Button) findViewById(R.id.progress_bar_btn);
        progressDialogBtn = (Button) findViewById(R.id.progress_dialog_btn);
        startModleBtn = (Button) findViewById(R.id.start_model_btn);
        diyTitleBtn = (Button) findViewById(R.id.diy_title_btn);
        popBtn = (Button) findViewById(R.id.pop_btn);
        listViewBtn = (Button) findViewById(R.id.list_view_btn);
        myFragmentBtn = (Button) findViewById(R.id.my_fragment_btn);
        recyclerViewBtn = (Button) findViewById(R.id.recycler_view_btn);
        updateUIBtn =  (Button) findViewById(R.id.update_UI_btn);
        jump_to_service_btn =  (Button) findViewById(R.id.jump_to_service_btn);
        jump_to_boradcast_btn = (Button) findViewById(R.id.jump_to_boradcast_btn);
        sendOfflineBtn = (Button) findViewById(R.id.boradcast_force_offline_btn);
        storage_persistence_btn = (Button) findViewById(R.id.storage_persistence_btn);
        setOnclickListener();

    }
    private void setOnclickListener(){
        OnClick onclick = new OnClick();
        normal.setOnClickListener(onclick);
        dialog.setOnClickListener(onclick);
        progressBarBtn.setOnClickListener(onclick);
        progressDialogBtn.setOnClickListener(onclick);
        startModleBtn.setOnClickListener(onclick);
        diyTitleBtn.setOnClickListener(onclick);
        popBtn.setOnClickListener(onclick);
        listViewBtn.setOnClickListener(onclick);
        myFragmentBtn.setOnClickListener(onclick);
        recyclerViewBtn.setOnClickListener(onclick);
        updateUIBtn.setOnClickListener(onclick);
        jump_to_service_btn.setOnClickListener(onclick);
        jump_to_boradcast_btn.setOnClickListener(onclick);
        sendOfflineBtn.setOnClickListener(onclick);
        storage_persistence_btn.setOnClickListener(onclick);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "OnResume");
//        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
//        int ori = mConfiguration.orientation; //获取屏幕方向
//        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
//            //横屏
//            Log.d(TAG, "当前为横屏");
////            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制为竖屏
//        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
//            //竖屏
////            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
//            Log.d(TAG, "当前为竖屏");
//        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestory");
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.na_btn:
                    Toast.makeText(getApplicationContext(), "跳转到正常活动",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.dial_btn:
                    Toast.makeText(getApplicationContext(), "跳转到对话活动",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case  R.id.progress_bar_btn:
                    Toast.makeText(getApplicationContext(), "跳转到进度条页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ProgressBarActivity.class);
                    break;
                case  R.id.progress_dialog_btn:
                    Toast.makeText(getApplicationContext(), "跳转到对话框进度条页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ProgressDialogActivity.class);
                    break;
                case R.id.start_model_btn:
                    Toast.makeText(getApplicationContext(), "跳转到启动模式页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ActivityLifeCycleTestButtons.class);
                    break;
                case R.id.diy_title_btn:
                    Toast.makeText(getApplicationContext(), "跳转到自定义标题栏页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, DIYActivity.class);
                    break;
                case R.id.pop_btn:
                    Toast.makeText(getApplicationContext(), "跳转到pop页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, PopUpWindowActivity.class);
                    break;
                case R.id.list_view_btn:
                    Toast.makeText(getApplicationContext(), "跳转到List View 页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ListViewButtonsActivity.class);
                    break;
                case R.id.update_UI_btn:
                    Toast.makeText(getApplicationContext(), "跳转到List View 页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, UpdateUIActivity.class);
                    break;
                case R.id.jump_to_service_btn:
                    Toast.makeText(getApplicationContext(), "启动服务",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ServiceMainActivity.class);
                    break;
                case R.id.my_fragment_btn:
                    Toast.makeText(getApplicationContext(), "跳转到fragment界面",Toast.LENGTH_SHORT).show();
                    //intent = new Intent(MainActivity.this, ContainerActivity.class);
                    intent = new Intent(MainActivity.this, NewsMainActivity.class);
                    break;
                case R.id.recycler_view_btn:
                    Toast.makeText(getApplicationContext(), "跳转到RecyclerView界面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, RecylerViewButtonsActivity.class);
                    break;
                case R.id.jump_to_boradcast_btn:
                    Toast.makeText(getApplicationContext(), "跳转到广播界面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, BroadCastMainActivity.class);
                    break;
                case R.id.boradcast_force_offline_btn:
                    //Toast.makeText(getApplicationContext(), "强制下线",Toast.LENGTH_SHORT).show();
                    Intent broIntent = new Intent("com.example.broadcast.FORCE_OFFLINE");
                    getLocalBroadcastManager().sendBroadcast(broIntent);
                    break;
                case R.id.storage_persistence_btn:
                    Toast.makeText(getApplicationContext(), "跳转到数据可持续化界面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, DataPersistenceMainActivity.class);
                    break;
                default:
                    break;
            }
            if(intent != null){
                startActivity(intent);
            }
        }
    }
    class MyTestReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "强制下线",Toast.LENGTH_SHORT).show();
        }
    }
}
