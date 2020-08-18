package com.example.anotherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileDescriptor;

public class AnotherMyService extends Service {
    public AnotherMyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return new IBinder() {
            @Nullable
            @Override
            public String getInterfaceDescriptor() throws RemoteException {
                return null;
            }

            @Override
            public boolean pingBinder() {
                return false;
            }

            @Override
            public boolean isBinderAlive() {
                return false;
            }

            @Nullable
            @Override
            public IInterface queryLocalInterface(@NonNull String s) {
                return null;
            }

            @Override
            public void dump(@NonNull FileDescriptor fileDescriptor, @Nullable String[] strings) throws RemoteException {

            }

            @Override
            public void dumpAsync(@NonNull FileDescriptor fileDescriptor, @Nullable String[] strings) throws RemoteException {

            }

            @Override
            public boolean transact(int i, @NonNull Parcel parcel, @Nullable Parcel parcel1, int i1) throws RemoteException {
                return false;
            }

            @Override
            public void linkToDeath(@NonNull DeathRecipient deathRecipient, int i) throws RemoteException {

            }

            @Override
            public boolean unlinkToDeath(@NonNull DeathRecipient deathRecipient, int i) {
                return false;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("AnotherMyService","onCreating......");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("AnotherMyService","onStartCommand......");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("AnotherMyService","onDestorying......");
    }
}
