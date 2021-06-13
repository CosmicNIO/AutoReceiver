package com.mktest.autoreceiver;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.IOException;

public class ScreenOnOffWorker extends Worker {
    private SocketClient socket;

    public ScreenOnOffWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    @NonNull
    @Override
    public Result doWork() {
        Log.d("POWERSTATUS", "ScreenOnOffWorker CALLED");
        String data = getInputData().getString("ActionStatus");
        socket = new SocketClient();
        try {
            socket.sendData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();
    }
}