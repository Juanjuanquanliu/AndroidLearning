package com.example.mvvmlearning.common;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

public class AppAdapters {

    private static final String TAG = "AppAdapters";

    @BindingAdapter({"toastMessage"})
    public static void toastMessage(View view, String message) {
        if (message != null) {
            Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
        }
    }

}
