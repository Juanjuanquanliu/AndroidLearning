package com.example.myandroidlearning.ServiceLearning.DownLoadTask;

public interface DownLoadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}

