package com.example.myandroidlearning.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.example.myandroidlearning.R;

public class ContainerActivity extends AppCompatActivity implements myFragment.IOMessageClick {
    private myFragment my_Fragment;
    private myFragment2 my_Fragment2;
    private Button button;
    private TextView container_title;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        //实例化一个fragment
        my_Fragment = myFragment.newInstance("我是myFrament的参数传递(Bundle)");
        getSupportFragmentManager().beginTransaction().add(R.id.my_fragment_container, my_Fragment,"my_Fragment").commitAllowingStateLoss();
        button = (Button) findViewById(R.id.changeFragment);
        container_title = (TextView) findViewById(R.id.container_title);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(my_Fragment2 == null){
                    my_Fragment2 = new myFragment2("我是myFrament2的参数传递(构造函数)");
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_fragment_container,my_Fragment2).commitAllowingStateLoss();
                    return;
                }
                if(!flag)
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_fragment_container,my_Fragment2).commitAllowingStateLoss();
                else
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_fragment_container,my_Fragment).commitAllowingStateLoss();
                flag = !flag;
            }
        });
    }
    public void setData(String text){
            container_title.setText(text);
    }

    @Override
    public void onClick(String text) {
            container_title.setText(text);
    }
}