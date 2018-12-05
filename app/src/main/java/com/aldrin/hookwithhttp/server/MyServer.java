package com.aldrin.hookwithhttp.server;

import fi.iki.elonen.NanoHTTPD;

/**
 * @date 18/12/5
 * @author Aldrin
 * 建立 Http 服务端
 */
public class MyServer extends NanoHTTPD {
    public MyServer(int port) {
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"code\":\"200\"}");

        return newFixedLengthResponse(builder.toString());
    }
}
