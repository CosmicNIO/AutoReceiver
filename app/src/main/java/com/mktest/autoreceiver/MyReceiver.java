package com.mktest.autoreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("POWERSTATUS", "RECEIVED");
        Intent myIntent = new Intent(context, BackgroundService.class);
        context.startService(myIntent);
    }
}