package com.aldrin.hookwithhttp.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.IOException;

/**
 * @date 18/12/5
 * @author Aldrin
 * android 中的 server 在此 server 启动 Http 服务端
 */
public class AndroidServer extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MyServer myServer = new MyServer(8080);
        try {
            myServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
