package com.jvm.outofmenmory;

/**
 * VM Args：-Xss128k
 * 虚拟机栈和本地方法栈OOM测试（仅作为第1点测试程序）
 * 
 * -Xss:128k
 * （设置每个线程的堆栈大小。JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。
 * 	根据应用的线程所需内存大小进行调整。在相同物理内存下，减少这个值能生成更多的线程。但是
 *  操作系统对一个进行内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右。）
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom = new JavaVMStackSOF();
		
		try {
			oom.stackLeak();
		} catch (Exception e) {
			System.out.println("Stack length:" + oom.stackLength);
			throw e;
		}
	}
}
