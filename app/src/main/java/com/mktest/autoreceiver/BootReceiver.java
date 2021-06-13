package com.mktest.autoreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import java.util.concurrent.TimeUnit;


public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("POWERSTATUS", "BOOT RECEIVER STARTED");
        String message = "BOOT RECEIVER STARTED";
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        WorkRequest powerOnRequest =
                new OneTimeWorkRequest.Builder(PowerOnWorker.class)
                        .setInitialDelay(10, TimeUnit.SECONDS)
                        .build();
        WorkManager.getInstance(context).enqueue(powerOnRequest);
    }
}