package com.example.mvvmlearning.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmlearning.R;
import com.example.mvvmlearning.databinding.ActivityLoginBinding;
import com.example.mvvmlearning.viewmodel.LoginViewModel;



public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private LoginViewModel mLoginViewModel;
    ActivityLoginBinding mActivityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding  = DataBindingUtil.setContentView(this, R.layout.activity_login);
        initViewModel();
        addListener();
        mActivityMainBinding.executePendingBindings();

    }

    private void initViewModel() {
        mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mActivityMainBinding.setLoginViewModel(mLoginViewModel);
        mActivityMainBinding.setLifecycleOwner(this);
    }

    private void addListener() {
        mLoginViewModel.getUserEmail().observe(this,
                new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        Log.d(TAG, "email changed : " + s);
//                        mLoginViewModel.setUserEmail(s);
                    }
                });

//        mLoginViewModel.getToastMessage().observe(this,
//                new Observer<String>() {
//                    @Override
//                    public void onChanged(String s) {
//                    }
//                });

    }
}
