package com.walkerwang.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TCPServer {
	
	private static final int SERVER_PORT = 8080;
	private List<MyChannel> all = new ArrayList<>();
	
	public static void main(String[] args) {
		new TCPServer().start();
	}
	
	public void start() {
		try {
			/*
			 * 创建ServerSocket
			 */
			// 创建一个ServerSocket在端口8080监听客户端套接字请求
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			
			System.out.println("----------Server启动-----------");
			
			//不断监听客户端请求
			while (true) {
				// 侦听并接收到此Socket的请求，请求到来的则产生一个Socket对象，并继续执行
				Socket socket = serverSocket.accept();
				System.out.println("与客户端(" + socket.getPort() + ")连接成功！");

				//创建一个线程池
				Executor service = Executors.newCachedThreadPool();
				MyChannel thread = new MyChannel(socket);
				all.add(thread);
				service.execute(thread);		//一条路径
				
				/*DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						
				while(true) {
					String msg = dis.readUTF();
					System.out.println(msg);
					
					//输出流
					dos.writeUTF("服务器:" + msg);
					dos.flush();
				}*/
				/*while(true) {	//写一个阻塞，如果没有使用多线程，这里便会阻塞在某一个用在，其他用户无法连接
					
				}*/
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//内部类，给每个客户端分配一个线程
	private class MyChannel implements Runnable {
		private BufferedReader console;
		private DataOutputStream dos;
		private DataInputStream dis;
		private boolean isRunning = true;
		
		public MyChannel() {
			//获取键盘输入
			console = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public MyChannel(Socket socket){
			this();
			try {
				//获取Socket的输出流，用来向客户端发送数据
				dos = new DataOutputStream(socket.getOutputStream());
				//获取Socket的输入流，用来接收客户端发送过来的数据
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis, dos);
				all.remove(this);	//移除自身
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
				all.remove(this);	//移除自身
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
//				String server = console.readLine();	//服务器回复的信息
				
//				dos.writeUTF("服务器-->" + msg);	//服务器接收的消息发送给请求的用户
				dos.writeUTF(msg);	
				dos.flush();
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis, dos);
				all.remove(this);	//移除自身
			}
		}
		
		/**
		 * 发送给其他客户端
		 */
		public void sendOthers() {
			String msg = receive();
			Iterator<MyChannel> iter = all.iterator();
			while(iter.hasNext()) {
				MyChannel other = iter.next();
				if(other == this) {
					continue;
				}
				//发送给其他客户端
				other.send(msg);
			}
		}
		
		
		@Override
		public void run() {
			while(isRunning) {
//				send(receive());	//服务器将自己接收到的数据直接发送出去
				sendOthers();		//数据转发。（将接收到的数据直接转发给其他客户端）
			}
		}
	}
}
