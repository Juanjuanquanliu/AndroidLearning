package com.example.myandroidlearning.DIY;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myandroidlearning.R;


public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        ImageButton back = (ImageButton) findViewById(R.id.title_back);
        ImageButton go = (ImageButton) findViewById(R.id.title_go);

        go.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "我也是销毁，没想到吧", Toast.LENGTH_SHORT).show();
                ((Activity)getContext()).finish();
            }
        });
        back.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
    }
}
