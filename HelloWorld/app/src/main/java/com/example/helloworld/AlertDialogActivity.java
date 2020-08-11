package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.helloworld.R;

public class AlertDialogActivity extends AppCompatActivity {
    private static final String TAG = "NormalActivity";
    private Button adDIY,adDIY2, adDefault, adRadio, adMultiply;
    private ProgressBar pb_hor, my_pb;
    private Button Login_btn;
    private ProgressDialog pdB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_alert_dialog);
        adDIY = (Button) findViewById(R.id.diy_ad_btn);
        adDIY2= (Button) findViewById(R.id.diy_ad_btn2);
        adDefault =(Button) findViewById(R.id.default_ad_btn);
        adRadio = (Button) findViewById(R.id.radio_ad_btn);
        adMultiply = (Button) findViewById(R.id.multiply_ad_btn);
        setOnclickListener();

    }
    private void setOnclickListener(){
        OnClick onClick = new OnClick();
        adDIY.setOnClickListener(onClick);
        adDIY2.setOnClickListener(onClick);
        adDefault.setOnClickListener(onClick);
        adRadio.setOnClickListener(onClick);
        adMultiply.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            View v;
            switch (view.getId()) {
                case R.id.default_ad_btn:
                    AlertDialog.Builder defaultBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                    defaultBuilder.setTitle("默认样式").
                            setMessage("中创牛逼").
                            setCancelable(false).setPositiveButton("OK, you are right", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext() , "你说的很对", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.radio_ad_btn:
                    AlertDialog.Builder radioBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] sex = new String[]{"男","女","其他"};
                    radioBuilder.setTitle("请选择你的性别").setCancelable(false).
                            setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getApplicationContext(), "选择成功", Toast.LENGTH_SHORT).show();
                                }
                            }).
                            setSingleChoiceItems(sex, 2, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getApplicationContext(),sex[i], Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                    break;
                case R.id.multiply_ad_btn:
                    AlertDialog.Builder multiplyBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] hobbies = new String[]{"唱","跳","rap","在中创加班"};
                    final boolean[] selected = new boolean[]{false, false, false, true};
                    multiplyBuilder.setTitle("兴趣爱好调查").
                            setCancelable(false).
                            setMultiChoiceItems(hobbies, selected, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                 if(b){
                                    Toast.makeText(getApplicationContext(), hobbies[i] + " is selected", Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "Finish", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.diy_ad_btn:
                    AlertDialog.Builder diyAlertBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                    diyAlertBuilder.setTitle("登录界面");
                    v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_progress_bar,null);
                    pb_hor = (ProgressBar) v.findViewById(R.id.progress_bar_hor);
                    my_pb =  (ProgressBar) v.findViewById(R.id.my_progress_bar);
                    Login_btn = (Button) v.findViewById(R.id.log_in_btn);
                    pb_hor.setProgress(5);
                    Login_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            pb_hor.setVisibility(View.VISIBLE);
                            my_pb.setVisibility(View.VISIBLE);
                            handler.sendEmptyMessage(0);
                        }
                    });

                    diyAlertBuilder.setView(v).show();
                    break;
                case R.id.diy_ad_btn2:
                    AlertDialog.Builder diy2AlertBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                    v = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.activity_progress_dialog, null);
                    Login_btn = (Button) v.findViewById(R.id.log_in_btn);
                    Login_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            pdB = new ProgressDialog(AlertDialogActivity.this);
                            pdB.setTitle("登录中请稍等");
                            pdB.setMessage("Loading.......");
                            pdB.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new ProgressDialog.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getApplicationContext(), "OK, exit now", Toast.LENGTH_SHORT).show();
                                }
                            });
                            pdB.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                            pdB.show();
                            handler2.sendEmptyMessage(0);
                        }
                    });
                    diy2AlertBuilder.setTitle("登录界面").setView(v).show();
                    break;
                default:
                    break;
            }
        }
    }
    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(pdB.getProgress() < 100){
                handler2.postDelayed(runnable2, 200);
            }else{
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                alertBuilder.setTitle("登陆信息").setCancelable(false).setMessage("登陆成功").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_LONG).show();
                    }
                }).show();
                pdB.setMessage("Loading Finished");
            }
        }
    };
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            pdB.setProgress(pdB.getProgress() + 5);
            handler2.sendEmptyMessage(0);
        }
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(pb_hor.getProgress() < 100){
                handler.postDelayed(runnable, 200);
            }else{
                pb_hor.setVisibility(View.GONE);
                my_pb.setVisibility(View.GONE);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                alertBuilder.setTitle("登陆信息").setCancelable(false).setMessage("登陆成功").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_LONG).show();
                    }
                }).show();

            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            pb_hor.setProgress(pb_hor.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
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
}