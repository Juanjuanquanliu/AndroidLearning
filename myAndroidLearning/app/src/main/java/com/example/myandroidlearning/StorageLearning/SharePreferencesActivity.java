package com.example.myandroidlearning.StorageLearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myandroidlearning.R;

public class SharePreferencesActivity extends AppCompatActivity {
    private ImageView share_preferences_test_iv, share_preferences_restore_iv;//重新练习ImageView
    private Button restore_btn;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);
        share_preferences_test_iv = findViewById(R.id.share_preferences_test_iv);
        share_preferences_restore_iv = findViewById(R.id.share_preferences_restore_iv);
        restore_btn = (Button) findViewById(R.id.restore_btn);
        textView = (TextView) findViewById(R.id.restore_tv);
        share_preferences_test_iv.setImageResource(R.drawable.apple);
        share_preferences_test_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SharePreferencesActivity.this,"sharePreferenceActivity",Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putString("imgSrc","https://img-blog.csdnimg.cn/20200818142818558.png#pic_center");
                editor.putInt("age",28);
                editor.putBoolean("Married",false);
                editor.apply();
            }
        });

        restore_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                StringBuilder stringBuilder = new StringBuilder();
                if(sharedPreferences.contains("name")) stringBuilder.append("name:" + sharedPreferences.getString("name","Null") + "\n");
                if(sharedPreferences.contains("age")) stringBuilder.append("age:" + sharedPreferences.getInt("age",0)+"\n");
                if(sharedPreferences.contains("Married")) stringBuilder.append("Married:" + sharedPreferences.getBoolean("Married",false));
                textView.setText(stringBuilder.toString());
                if(sharedPreferences.contains("imgSrc"))
                Glide.with(SharePreferencesActivity.this).load(sharedPreferences.getString("imgSrc","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597839160424&di=29a15d76d8305f2bf2c0ca9a1e57844d&imgtype=0&src=http%3A%2F%2Fp9.qhimg.com%2Ft01f494a2a2f5aff43e.png")).into(share_preferences_restore_iv);
            }
        });

    }
}