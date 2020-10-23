package com.example.mvvmlearning.repository;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import com.example.mvvmlearning.bean.User;
import com.example.mvvmlearning.room.UserDatabase;

public class LoginRepository {
    private static final String TAG = "LoginRepository";

    public static volatile LoginRepository sLoginRepository;
    private static UserDatabase mUserDatabase;

    /**
     * Login repository.
     *
     * @return AirVolumeRepository singleton
     */

    public static LoginRepository getInstance(Context context) {
        mUserDatabase = UserDatabase.getInstance(context);

        if (sLoginRepository == null) {
            synchronized (LoginRepository.class) {
                if(sLoginRepository == null) {
                    sLoginRepository = new LoginRepository();
                }
            }
        }
        return sLoginRepository;
    }

    public boolean isRegistedUser(User user) {
        Log.d(TAG, "user: "+ user.getEmail() + "\t password: " + user.getPassword());

        User queryUser = mUserDatabase.userDao().getRegistedUser(user.getEmail());

        if (queryUser == null) {
            return false;
        } else {
            Log.d(TAG, "user: "+ queryUser.getEmail() + "\t password: " + queryUser.getPassword());
            Log.d(TAG, "isRegistedUser: true");
            return true;
        }
    }

    public boolean registeUser(User user) {
        Log.d(TAG, "user: "+ user.getEmail() + "\t password: " + user.getPassword());

        Boolean isRegisted = isRegistedUser(user);
        if (!isRegisted) {
            mUserDatabase.userDao().registeUser(user);
            Log.d(TAG, "Registed Succeed");
            return true;
        } else {
            Log.d(TAG, "Already Registed ");
            return false;
        }
    }

    public boolean loginUser(User user) {
        Log.d(TAG, "user: "+ user.getEmail() + "\t password: " + user.getPassword());

        User queryUser = mUserDatabase.userDao().getUser(user.getEmail(), user.getPassword());
        Log.d(TAG, "queryUser: " + queryUser);

        if ( queryUser != null) {
            Log.d(TAG, "queryUser: " + queryUser.getEmail());
            return true;
        } else {
            return false;
        }
    }

}
