package com.mktest.autoreceiver;

import android.util.Log;

import java.io.*;
import java.net.*;

public class SocketClient {

    public void sendData(String data) throws IOException {

        Socket s = new Socket();
        String host = "192.168.1.7";
        PrintWriter s_out = null;

        try
        {
            s.connect(new InetSocketAddress(host , 23));
            s_out = new PrintWriter( s.getOutputStream(), true);
        }

        catch (UnknownHostException e)
        {
            Log.e("ERROR", "Don't know about host : " + host);
        }

        //Send message to server
        Log.d("POWERSTATUS: ", data);
        s_out.println(data);
    }
}
