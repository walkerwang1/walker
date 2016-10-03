package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

/*
 * 判断一个数是否为2的次方，不能使用任何类库以及内置函数
 */
public class Qunar01_2n {

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int a, b;
		while (cin.hasNextInt()) {
			a = cin.nextInt();
//			System.out.println(fun2(a));
			System.out.println(a>>2);
		}
	}

	// 方法一
	public static boolean fun(int n) {
//		return (n > 0) && ((n & (n - 1)) == 0);
		int result = ((n&(n-1))==0) ? (1) : (0);
		return result==1?true:false;
	}

	// 方法二
	public static boolean fun2(int n) {
		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}
}
