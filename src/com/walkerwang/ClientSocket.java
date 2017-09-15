package com.walkerwang;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocket {
	public static void main(String[] args) throws Exception {
		String IPADDRESS  = "192.168.1.104";
//		String IPADDRESS  = "127.0.0.1";
//		String IPADDRESS = " 10.0.0.2";
		int PORT = 1110;
		Socket socket = new Socket(IPADDRESS, PORT);
		
		InputStream is;
		OutputStream os;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		
		if (socket != null) {
			
			System.out.println("not null");
			
//				
//				os = socket.getOutputStream();
//				oos = new ObjectOutputStream(os);
//				
//				Parameters param = new Parameters();
//				param.setN(8888);
//				
//				oos.writeObject(param);
//				oos.flush();
				
		} else{
			System.out.println("null");
		}
	}
}
