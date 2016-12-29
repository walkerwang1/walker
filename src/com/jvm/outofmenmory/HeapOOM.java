package com.jvm.outofmenmory;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试
 * 
 * @author walkerwang
 *
 */
public class HeapOOM {

	static class OOMObject {
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		
		while(true) {
			list.add(new OOMObject());
			System.out.println("new");
		}
	}
}
