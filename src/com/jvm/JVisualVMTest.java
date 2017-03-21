package com.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 测试jvisualvm的监控功能
 *
 */

public class JVisualVMTest {
	public static void main(String[] args) throws InterruptedException {
		// 模拟占用资源的部分
		for(int i = 0; i < 100; i++){
			Map<String, String> map = new HashMap<String, String>();
			map.put("" + i, "" + i);
			Thread t = new Thread(){
				public void run(){
					try {
						Thread.sleep(200 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			// sleep 1s
			Thread.sleep(1000);
		}

	}

}