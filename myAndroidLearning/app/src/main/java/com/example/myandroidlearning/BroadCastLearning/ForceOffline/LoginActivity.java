package com.example.myandroidlearning.BroadCastLearning.ForceOffline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myandroidlearning.MainActivity;
import com.example.myandroidlearning.R;

public class LoginActivity extends BaseActivity {
    private EditText account;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account = (EditText) findViewById(R.id.editTextAccount);
        password = (EditText) findViewById(R.id.editTextPassWord);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountStr = account.getText().toString();
                String passwordStr = password.getText().toString();
                if(accountStr.equals("admin") && passwordStr.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "account or password is wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}