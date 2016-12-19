package com.concurrent;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.walkerwang.net.CloseUtil;

/**
 * 该类为多线程类，用于服务器
 * 
 * 暂时没有用到
 *
 */
public class ServerThread implements Runnable{
	private static Socket socket = null;
	private static BufferedReader console;
	private static DataOutputStream dos;
	private static DataInputStream dis;
	private boolean isRunning = true;
	
	public ServerThread() {
		//获取键盘输入
		console = new BufferedReader(new InputStreamReader(System.in));
		try {
			//获取Socket的输出流，用来向客户端发送数据
			dos = new DataOutputStream(socket.getOutputStream());
			//获取Socket的输入流，用来接收客户端发送过来的数据
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis, dos);
		}
	}
	
	public ServerThread(Socket socket){
		this();
		this.socket = socket;
		
	}
	
	@Override
	public void run() {
		while(isRunning) {
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
			CloseUtil.closeAll(dis, dos);
		}
		return msg;
	}
	
	/**
	 *发送数据 
	 */
	public void send(String msg) {
		if(msg == null || msg.equals(""))
			return;
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis, dos);
		}
	}

}
