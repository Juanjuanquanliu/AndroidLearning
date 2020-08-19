package com.example.myandroidlearning.StorageLearning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidlearning.BroadCastLearning.ForceOffline.BaseActivity;
import com.example.myandroidlearning.BroadCastLearning.ForceOffline.LoginActivity;
import com.example.myandroidlearning.MainActivity;
import com.example.myandroidlearning.R;

public class StorageLoginActivity extends BaseActivity {
    private EditText account, password;
    private CheckBox rememberPass;
    private Button login;
    private SharedPreferences pre;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_password_login);
        account = (EditText) findViewById(R.id.editTextAccount);
        password = (EditText) findViewById(R.id.editTextPassWord);
        login = (Button) findViewById(R.id.login);
        rememberPass = (CheckBox) findViewById(R.id.remember_password);
        pre = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = pre.getBoolean("remember_password",false);
        if(isRemember){
            account.setText(pre.getString("account",""));
            password.setText(pre.getString("password",""));
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountStr = account.getText().toString();
                String passwordStr = password.getText().toString();

                if (accountStr.equals("admin") && passwordStr.equals("123456")) {
                    editor = pre.edit();
                    if(rememberPass.isChecked()){
                        editor.putString("account",account.getText().toString());
                        editor.putString("password",password.getText().toString());
                        editor.putBoolean("remember_password",true);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(StorageLoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(StorageLoginActivity.this, "account or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}