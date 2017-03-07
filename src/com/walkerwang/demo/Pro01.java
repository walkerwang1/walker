package com.walkerwang.demo;

import java.util.Scanner;

public class Pro01 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    while (in.hasNextInt()) {//注意while处理多个case
			int n = in.nextInt();
			if (n < 2 || n > 10000) {
				System.out.println("No");
				return;
			}
			boolean flag = false;
			int p = 1;
			int q = 2;
			while(p <= n/2) {
				q = 2;
				if (isPrime(p)) {
					while(Math.pow(p, q) <= n) {
						if (Math.pow(p, q) == n) {
							flag = true;
							break;
						}
						q++;
					}
				}
				if (flag) {
					System.out.println(p + " " + q);
					break;
				}
				p++;
			}
			if (!flag) {
				System.out.println("No");
			}
	    }
	}
	
	 public static boolean isPrime(int a) {  
	        boolean flag = true;  
	        if (a < 2) {// 素数不小于2  
	            return false;  
	        } else {  
	            for (int i = 2; i <= Math.sqrt(a); i++) {  
	  
	                if (a % i == 0) {// 若能被整除，则说明不是素数，返回false  
	                    flag = false;  
	                    break;// 跳出循环  
	                }  
	            }  
	        }  
	        return flag;  
	    }
}
