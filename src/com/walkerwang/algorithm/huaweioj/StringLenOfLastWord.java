package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringLenOfLastWord {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String[] arr = str.split(" ");
		System.out.println(arr[arr.length-1].length());
	}
}
