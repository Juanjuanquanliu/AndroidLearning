package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myandroidlearning.ActivityLifeCycleTest.ActivityLifeCycleTestButtons;

public class MainActivity extends AppCompatActivity {
    private Button normal, dialog,progressBarBtn, progressDialogBtn,startModleBtn;
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

        setOnclickListener();
    }
    private void setOnclickListener(){
        OnClick onclick = new OnClick();
        normal.setOnClickListener(onclick);
        dialog.setOnClickListener(onclick);
        progressBarBtn.setOnClickListener(onclick);
        progressDialogBtn.setOnClickListener(onclick);
        startModleBtn.setOnClickListener(onclick);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "OnResume");
        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏
            Log.d(TAG, "当前为横屏");
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制为竖屏
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
            Log.d(TAG, "当前为竖屏");
        }
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

    private class OnClick implements View.OnClickListener{
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
                    Toast.makeText(getApplicationContext(), "跳转到对话框进度条页面",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ActivityLifeCycleTestButtons.class);
                    break;
                default:
                    break;
            }
            if(intent != null){
                startActivity(intent);
            }
        }
    }
}
