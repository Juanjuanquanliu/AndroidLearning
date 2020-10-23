package com.example.mvvmlearning;

import android.app.Application;
import android.content.Context;

import com.example.mvvmlearning.room.UserDatabase;

public class LoginApplication extends Application {
        private static final String TAG = "LoginApplication";
        private static volatile LoginApplication sLoginApplication ;
        @Override
        public void onCreate() {
            super.onCreate();
            sLoginApplication = this;
        }

        public static LoginApplication getInstance() {

            return sLoginApplication;
        }



    }
