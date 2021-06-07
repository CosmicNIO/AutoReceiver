package com.mktest.autoreciever;

import android.util.Log;

import java.io.*;
import java.net.*;

public class SocketClient {

    public void sendData() throws IOException {

        Socket s = new Socket();
        String host = "192.168.1.7";
        PrintWriter s_out = null;

        try
        {
            s.connect(new InetSocketAddress(host , 23));
            Log.d("TEST","Connected");

            //writer for socket
            s_out = new PrintWriter( s.getOutputStream(), true);
        }

        //Host not found
        catch (UnknownHostException e)
        {
            Log.e("ERROR", "Don't know about host : " + host);
        }

        //Send message to server
        String message = "PWON";
        s_out.println( message );

        Log.d("TEST", "Message sent");

    }
}
