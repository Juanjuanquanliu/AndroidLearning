package com.example.myandroidlearning.DIY;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myandroidlearning.R;

public class myDialog extends Dialog implements View.OnClickListener{
    private TextView mdTitle, mdMsg, mdCancle, mdConfirm;
    private String title, msg, cancel, confirm;
    private myOnCancleListener cancleListener;
    private myOnConfirmListener confirmListener;

    public myDialog(@NonNull Context context){
        super(context);
    }
    public myDialog(@NonNull Context context, int themeId){
        super(context, themeId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);

        //设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams P = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        P.width = (int)(size.x * 0.8);
        getWindow().setAttributes(P);

        mdTitle = (TextView) findViewById(R.id.diy_dialog_tv_title);
        mdMsg = (TextView) findViewById(R.id.diy_dialog_tv_msg);
        mdCancle = (TextView) findViewById(R.id.diy_dialog_tv_cancle);
        mdConfirm = (TextView) findViewById(R.id.diy_dialog_tv_confirm);
        if(!TextUtils.isEmpty(title)){
            mdTitle.setText(title);
        }

        if(!TextUtils.isEmpty(msg)){
            mdMsg.setText(msg);
        }

        if(!TextUtils.isEmpty(cancel)){
            mdCancle.setText(cancel);
        }

        if(!TextUtils.isEmpty(confirm)){
            mdConfirm.setText(confirm);
        }
        mdCancle.setOnClickListener(this);
        mdConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.diy_dialog_tv_cancle:
                if(cancleListener != null){
                    cancleListener.onCancle(this);
                }
                dismiss();
                break;
            case R.id.diy_dialog_tv_confirm:
                if(confirmListener != null){
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
            default:
                break;
        }
    }

    public myDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public myDialog setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public myDialog setCancel(String cancel, myOnCancleListener listener) {
        this.cancel = cancel;
        this.cancleListener = listener;
        return this;
    }

    public myDialog setConfirm(String confirm, myOnConfirmListener listener){
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    public interface myOnCancleListener{
        void onCancle(myDialog dialog);
    }

    public interface myOnConfirmListener{
        void onConfirm(myDialog dialog);
    }
}
