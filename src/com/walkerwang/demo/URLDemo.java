package com.walkerwang.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class URLDemo {
	public static void main(String[] args) throws IOException {
		// 绝对路径构建
		
		 URL url = new URL("http://www.baidu.com:80/index.html#aaa?username=wang");
		 System.out.println("协议：" + url.getProtocol());
		 System.out.println("域名：" + url.getHost()); 
		 System.out.println("端口：" + url.getPort()); 
		 System.out.println("资源：" + url.getFile());
		 System.out.println("相对路径：" + url.getPath()); 
		 System.out.println("锚点：" + url.getRef()); System.out.println("参数：" + url.getQuery());
		 //如果有锚点，锚点后面的参数都当成锚点处理
		 /*
		  * 
			协议：http
			域名：www.baidu.com
			端口：80
			资源：/index.html
			相对路径：/index.html
			锚点：aaa?username=wang
			参数：null
		  */
		 

		 url = new URL("https://www.baidu.com");
		
		/*InputStream is = url.openStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1) {
			System.out.println(new String(flush, 0, len));
		}
		is.close();*/
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
		BufferedWriter bw = 
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));
		String msg = null;
		while((msg = br.readLine()) != null){
			System.out.println(msg);
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		
		bw.close();
		br.close();
	}
}
