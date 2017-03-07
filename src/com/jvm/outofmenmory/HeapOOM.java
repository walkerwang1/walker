package com.jvm.outofmenmory;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试
 * 
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * -Xmx:20m
 * （设置JVM最大可用内存为20M）
 * 
 * -Xms:20m
 * （设置JVM促使内存为20M，此值可以设置与-Xmx相同，以免每次垃圾回收完成后JVM重新分配内存）
 * 
 * -XX:+HeapDumpOnOutOfMemoryError
 * （调试参数：默认关闭。在发生内存溢出异常时是否生成堆储快照，关闭则不生成）
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
