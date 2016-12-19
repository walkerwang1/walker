package com.concurrent;

import java.net.Socket;

public class TCPClient {

	//指定服务器的地址和端口（客户端的端口有系统分配）
	public static String IP = "localhost";
	public static int PORT = 8080;	
	
	public static void main(String[] args) {
		try {
			
			//创建一个流套接字（TCP套接字）并将其连接到指定IP地址的指定端口号（本处是本机）
			Socket socket = new Socket(IP, PORT);
			//60s超时
			socket.setSoTimeout(60000);
			
			//控制台输出流
			new Thread(new SendThread(socket)).start();	//socket对应的输出流
			
			//输入流
			new Thread(new ReceiveThread(socket)).start();	//socket对应的输入流
				
			
			/**
			 * 发送客户端准备传输的信息
			 */
			//获取键盘输入
		/*	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			//获取Socket的输出流，用来发送数据到服务端
			PrintStream out = new PrintStream(socket.getOutputStream(), true);
			//获取Socket的输入流，用来接收从服务器发送过来的数据
			BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			boolean flag = true;
			while(flag){
				System.out.print("客户端(" + "" +")：");
				//客户端发送数据
				String str = input.readLine();
				out.println(str);
				
				//客户端接收数据
				if("bye".equals(str)){
					flag = false;
				}else{
					try {
						//从服务器接收数据有个时间限制（系统自设，也可以自己设置），超过了这个时间，便会超出一场
						String reply = buff.readLine();
						System.out.println("服务器:" + reply);
					} catch (Exception e) {
						System.out.println("超时");
					}
				}
			}
			
			 //关闭Socket
			input.close(); 
			*/
			
			/*if(socket != null){
				//如果构造函数建立起了连接，则关闭套接字
				socket.close();//只关闭Socket，其关联的输入输出流也会被关闭
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
