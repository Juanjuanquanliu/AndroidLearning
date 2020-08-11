package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button normal, dialog,progressBarBtn, progressDialogBtn;
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
        setOnclickListener();
    }
    private void setOnclickListener(){
        OnClick onclick = new OnClick();
        normal.setOnClickListener(onclick);
        dialog.setOnClickListener(onclick);
        progressBarBtn.setOnClickListener(onclick);
        progressDialogBtn.setOnClickListener(onclick);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume");
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
                default:
                    break;
            }
            if(intent != null){
                startActivity(intent);
            }
        }
    }
}
