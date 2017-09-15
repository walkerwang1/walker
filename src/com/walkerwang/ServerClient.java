package com.walkerwang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(1118);
		  
	            try {
					Socket socket = server.accept();
					
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					Parameters param = (Parameters)ois.readObject();
					System.out.println(param.getN());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	}
}
