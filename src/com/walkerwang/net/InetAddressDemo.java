package com.walkerwang.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress[] address = InetAddress.getAllByName("www.baidu.com");
		for(InetAddress addr : address) {
			System.out.println(addr.getHostAddress());
		}
		
		InetAddress address2 = InetAddress.getByName("www.baidu.com");
		System.out.println(address2.getHostAddress());
		System.out.println();
		System.out.println(InetAddress.getLocalHost().isLoopbackAddress());
		System.out.println(InetAddress.getLoopbackAddress().isLoopbackAddress());
		/*System.out.println(address);
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		System.out.println(InetAddress.getLocalHost());
		System.out.println(address2);
		System.out.println(address2.getHostAddress());
		System.out.println(address2.getHostName()); 	//不存在ip和域名的映射
*/	}
}
