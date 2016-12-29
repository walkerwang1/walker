package com.jvm.outofmenmory;

/**
 * VM Args：-Xss128k
 * 虚拟机栈和本地方法栈OOM测试（仅作为第1点测试程序）
 * 
 * @author walkerwang
 *
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
