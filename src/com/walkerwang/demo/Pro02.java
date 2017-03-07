package com.walkerwang.demo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pro02 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
//		while (in.hasNextInt()) {// 注意while处理多个case
			Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
			int i, j, k;
			boolean flag = false;
			int n = in.nextInt();
			int L = in.nextInt();
			if (n < 1 || n > 1000000000 || L < 2 || L > 100) {
				System.out.println("No");
				return;
			}
			int sum = 0;
			for (i = 1; i <= (n + 1) / 2; i++) {
				sum = 0;
				for (j = i; sum < n; j++) {
					sum += j;
				}
				j--;
				if (sum == n && i >= L) {
					ArrayList<Integer> list = new ArrayList<>();
					for (k = i; k < j; k++) {
						list.add(k);
					}
					list.add(k);
					map.put(list.size(), list);
					flag = true;
				}
			}
			
			
			System.out.println(map);
			if (flag) {
				ArrayList<Integer> ret = map.entrySet().iterator().next().getValue();
				for ( i = 0; i < ret.size(); i++) {
					if (i != ret.size()-1) {
						System.out.print(ret.get(i) + " ");
					} else {
						System.out.print(ret.get(i));
					}
				}
					
			} else {
				System.out.println("No");
			}
		}
//	}
}
