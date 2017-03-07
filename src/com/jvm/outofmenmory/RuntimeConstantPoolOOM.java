package com.jvm.outofmenmory;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 * （常量池分配在永久代内，运行时常量池属于方法区）
 * 
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * -XX:MaxPermSize
 * （设置持久代（永久代、方法区容量）的最大值，大部分情况下默认值是64M）
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		//使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<>();
		//10MB的PermSize在integer范围内足够产生OOM
		int i = 0;
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
