package com.walkerwang.algorithm.swordoffer;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(nFibonacci(31));
		System.out.println(nFibonacci2(31));
	}
	
	//1-�ݹ�
	public static int nFibonacci(int n){
		if(n < 0){
			return 0;
		}else if(n == 1 || n == 2){
			return 1;
		}else if(n <= 39){
			return nFibonacci(n-1) + nFibonacci(n-2);
		}else {
			return 0;
		}
	}
	
	//2-������������
	public static int nFibonacci2(int n){
		int a=1, b=1, c=0;
		if (n < 0) {
			return 0;
		}else if(n==1 || n==2){
			return 1;
		}else {
			for(int i=3; i<=n; ++i){
				c = a+b;
				a = b;
				b = c;
			}
			return c;
		}
	}
}
