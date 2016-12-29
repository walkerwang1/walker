package com.jvm.outofmenmory;

/**
 * VM Args: -XX:PermSize=10M  -XX:MaxPermSize=10M
 * 借助CGLib使方法区出现内存溢出异常
 * 
 * @author walkerwang
 *
 */
public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		while(true) {
		}
	}
}
