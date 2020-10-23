package com.example.mvvmlearning.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmlearning.BR;
import com.example.mvvmlearning.LoginApplication;
import com.example.mvvmlearning.bean.User;
import com.example.mvvmlearning.repository.LoginRepository;

public class LoginViewModel extends ViewModel {
    private static final String TAG = "LoginViewModel";
    private final String successMessage = "Login was successful";
    private final String errorMessage = "Email or Password not valid";

    private MutableLiveData<String> mEmail;
    private MutableLiveData<String> mPassword;
    private MutableLiveData<String> mToastMessage;
    private PopupWindow popupWindow;
    private LoginRepository mLoginRepository;
    private LoginApplication mLoginApplication;

    public LoginViewModel() {
        mEmail = new MutableLiveData<String>("");
        mPassword = new MutableLiveData<String>("");
        mToastMessage = new MutableLiveData<String>("");

        mLoginApplication = new LoginApplication().getInstance();
        mLoginRepository = new LoginRepository().getInstance(mLoginApplication.getApplicationContext());
    }


    public void setUserEmail(String email) {
        this.mEmail.postValue(email);
    }
    public void setUserPassword(String password) {
        this.mPassword.postValue(password);
    }

    public void setToastMessage(String toastMessage) {
        this.mToastMessage.postValue(toastMessage);
    }

    public MutableLiveData<String> getUserEmail() {
        return mEmail;
    }

    public MutableLiveData<String> getUserPassword() {
        return mPassword;
    }

    public MutableLiveData<String> getToastMessage() {
        return mToastMessage;
    }


    public void onLoginClicked() {
        Log.d(TAG, "email: " + mEmail.getValue() + "\t password: " + mPassword.getValue());
        User user = new User(mEmail.getValue(), mPassword.getValue());
        Boolean isLogin = mLoginRepository.loginUser(user);
        Log.d(TAG, "Login Status: " + isLogin);
        if (isLogin) {
            setToastMessage(successMessage);
        } else {
            setToastMessage(errorMessage);
            mPassword.setValue("");
        }
    }

    public void onRegisterClicked() {
        Log.d(TAG, "email: " + mEmail.getValue() + "\t password: " + mPassword.getValue());
        User user = new User(mEmail.getValue(), mPassword.getValue());
        Boolean isRegisted = mLoginRepository.isRegistedUser(user);
        Log.d(TAG, "Registed Status: " + isRegisted);
        mLoginRepository.registeUser(user);
        isRegisted = mLoginRepository.isRegistedUser(user);
        Log.d(TAG, "Registed Status: " + isRegisted);


    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(mEmail.getValue()) && Patterns.EMAIL_ADDRESS.matcher(mEmail.getValue()).matches() && mPassword.getValue().length() > 5;
    }
}