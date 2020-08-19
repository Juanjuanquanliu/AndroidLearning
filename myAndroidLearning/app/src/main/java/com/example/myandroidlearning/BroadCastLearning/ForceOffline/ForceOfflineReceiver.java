package com.example.myandroidlearning.BroadCastLearning.ForceOffline;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

public class ForceOfflineReceiver extends BroadcastReceiver {
    private Context myContext;
    public ForceOfflineReceiver(){
        super();
    }
    public ForceOfflineReceiver(Context context){
        myContext = context;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "强制下线",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
        builder.setTitle("Warning");
        builder.setMessage("You are forced to be offline. Please try to login again.");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll();
                        Intent intent = new Intent(myContext, LoginActivity.class);
                        myContext.startActivity(intent);
                    }
                });
        builder.show();
    }
}
