package com.aldrin.hookwithhttp.server;

import android.util.Log;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class MyServer extends NanoHTTPD {

    private static final String TAG = "MyServer";

    private static volatile MyServer myServer = null;

    public static MyServer getInstance(){
        if (myServer == null){
            synchronized (MyServer.class){
                if (myServer == null){
                    myServer = new MyServer(8080);
                }
            }
        }
        return myServer;
    }

    private MyServer(int port) {
        super(port);
        try {
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "MyServer: start success");
    }

    @Override
    public Response serve(IHTTPSession session) {

        Method method = session.getMethod();
        String uri = session.getUri();

        if (method == Method.GET) {
            String jsonString = "{\"code\": \"201\",\"msg\": \"Failed, Don`t Support Method GET \",\"data\": {}}";
            return newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT, jsonString);
        }

        return super.serve(session);
    }
}
