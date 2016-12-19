package com.concurrent;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import com.walkerwang.net.CloseUtil;

public class ReceiveThread implements Runnable {
	
	//管道输出流
	private DataInputStream dis;
	//线程标识
	private boolean isRunning = true;
	
	public ReceiveThread() {
		
	}
	
	public ReceiveThread(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}
	
	/**
	 * 接收数据
	 */
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}

	@Override
	public void run() {
		//线程体
		while(isRunning) {
			System.out.println(receive());
		}
	}
}
