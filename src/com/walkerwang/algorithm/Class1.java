package com.walkerwang.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Class1 {

	/*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        } 
        System.out.println(ans);
	}*/
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int val;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
                val = in.nextInt();
                list.add(val);
        }
		list.add(list.get(0));
		System.out.println(list);
		int max = 0;
		for(int i = 0; i < list.size()-1; i++) {
			int a = list.get(i) - list.get(i+1);
			a = a > 0 ? a : -a;
			if (a > max) {
				max = a;
			}
		}
		System.out.println(max);
    } 
	
}
