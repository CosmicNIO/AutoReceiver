package com.mktest.autoreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;


public class ScreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("POWERSTATUS", "SCREEN RECEIVER STARTED");
        String actionString;
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            actionString = "PWON";
        } else {
            actionString = "PWSTANDBY";
        }
        Data.Builder data = new Data.Builder();
        data.putString("ActionStatus", actionString);
        OneTimeWorkRequest screenOnOffRequest = new OneTimeWorkRequest.Builder(ScreenOnOffWorker.class)
                        .setInputData(data.build())
                        .build();
        WorkManager.getInstance(context).enqueue(screenOnOffRequest);
    }
}
