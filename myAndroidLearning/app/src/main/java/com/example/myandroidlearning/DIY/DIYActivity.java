package com.example.myandroidlearning.DIY;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myandroidlearning.R;

import java.sql.BatchUpdateException;

public class DIYActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy);
        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.hide();
        }
        final TextView txv = (TextView) findViewById(R.id.title_text);
        txv.setText("Title Text");
        txv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txv.getText() == "Title Text")
                    txv.setText("你居然发现了,我是可以变的");
                else
                    txv.setText("Title Text");
            }
        });
        Button diy_dialog_btn = (Button) findViewById(R.id.diy_dialog_btn);
        diy_dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog mD = new myDialog(DIYActivity.this,R.style.myDialog);
                mD.setTitle("订单提示").setMsg("是否删除订单？").setCancel("取消",new myDialog.myOnCancleListener(){
                    @Override
                    public void onCancle(myDialog dialog) {
                        Toast.makeText(DIYActivity.this, "取消成功", Toast.LENGTH_SHORT).show();
                    }
                }).setConfirm("确定", new myDialog.myOnConfirmListener() {
                    @Override
                    public void onConfirm(myDialog dialog) {
                        Toast.makeText(DIYActivity.this, "取消成功", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}