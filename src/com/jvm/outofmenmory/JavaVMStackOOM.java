package com.jvm.outofmenmory;

/**
 * VM args：-Xss2M
 * 创建线程导致内存溢出异常
 * @author walkerwang
 *
 */
public class JavaVMStackOOM {

	private void dontStop() {
		while(true) {
		}
	}
	
	public void stackLeakByThread() {
		while(true) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
