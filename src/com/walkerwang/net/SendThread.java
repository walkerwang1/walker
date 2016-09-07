package com.walkerwang.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SendThread implements Runnable {

	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	//控制线程
	private boolean isRunning = true;
	
	public SendThread() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public SendThread(Socket socket) {
		this();
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dos, console);
		}
	}
	
	/**
	 * 从控制台接收数据
	 */
	public String getMsgFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 发送数据
	 */
	public void send() {
		String msg = getMsgFromConsole();
		try {
			if(msg != null && !msg.equals("")){
				dos.writeUTF(msg);
				dos.flush();		//强制刷新
			}
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dos, console);
		}
	}
	
	@Override
	public void run() {
		System.out.println("客户端：");
		while(isRunning) {
			send();
		}
	}
	
	
}
