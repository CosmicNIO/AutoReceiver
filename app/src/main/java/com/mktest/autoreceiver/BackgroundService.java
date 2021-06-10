package com.mktest.autoreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class BackgroundService extends Service {

    private SocketClient socket;

    public BackgroundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("POWERSTATUS", "SERVICE STARTED");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service start", Toast.LENGTH_LONG).show();

        socket = new SocketClient();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket.sendData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        stopSelf();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service end", Toast.LENGTH_LONG).show();
    }
}