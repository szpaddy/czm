package com.czmen.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class HermRMISocket extends RMISocketFactory {
	   public ServerSocket createServerSocket(int port) throws IOException {
	        if (port == 0)
	            port = 8388;
	        return new ServerSocket(port);
	    }

	    public Socket createSocket(String host, int port) throws IOException {
	        return new Socket(host, port);
	    }
}
