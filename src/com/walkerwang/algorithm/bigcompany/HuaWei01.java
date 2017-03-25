package com.walkerwang.algorithm.bigcompany;

import java.util.Arrays;
import java.util.Scanner;

public class HuaWei01 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String[] arr = in.nextLine().split(",");
			String a = arr[0];
			String b = arr[1];
			if (a.substring(0, 1).equals("-") || b.substring(0, 1).equals("-")) {
				System.out.println("-1");
				return;
			}
			int a_val = Integer.valueOf(a);
			int b_val = Integer.valueOf(b);
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