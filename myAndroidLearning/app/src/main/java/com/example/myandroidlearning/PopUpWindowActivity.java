package com.example.myandroidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopUpWindowActivity extends AppCompatActivity {
    private Button pop;
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);
        pop = (Button) findViewById(R.id.pop_window_btn);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(PopUpWindowActivity.this).inflate(R.layout.layout_pop, null);
                final TextView textView1 = (TextView) view.findViewById(R.id.pop_tv_1);
                textView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        Toast.makeText(PopUpWindowActivity.this, "点击了"+textView1.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
                popupWindow = new PopupWindow(view,  pop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(pop);
            }
        });
    }
}