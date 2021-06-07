package com.mktest.autoreciever;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import java.io.PrintWriter;
import java.net.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends Activity {

    private SocketClient socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }
}