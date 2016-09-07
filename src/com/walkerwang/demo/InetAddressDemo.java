package com.walkerwang.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getByName("www.baidu.com");
		InetAddress address2 = InetAddress.getByName("119.75.218.70");
		System.out.println(address);
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		System.out.println(InetAddress.getLocalHost());
		System.out.println(address2);
		System.out.println(address2.getHostAddress());
		System.out.println(address2.getHostName()); 	//不存在ip和域名的映射
	}
}
