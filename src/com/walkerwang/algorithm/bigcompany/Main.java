package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			String[] arr = in.nextLine().split(",");
			String a = arr[0];
			String b = arr[1];
			System.out.println(a + ":" + b);
			int a_val = Integer.valueOf(a);
			int b_val = Integer.valueOf(b);
			System.out.println(a_val);
			System.out.println(b_val);
			if (a_val < 0) {
				a_val *= -1;
			}
			if (b_val < 0) {
				b_val *= -1;
			}
			if (a_val < 1 || a_val > 70000) {
				System.out.println("-1");
				return;
			}
			if (b_val < 1 || b_val > 70000) {
				System.out.println("-1");
				return;
			}
			StringBuilder sb = new StringBuilder(a);
			int aa = Integer.valueOf(sb.reverse().toString());
			sb = new StringBuilder(b);
			int bb = Integer.valueOf(sb.reverse().toString());
			System.out.println(aa + bb);
		}
	}
	
}
