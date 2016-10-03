package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

public class ScannerInstance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string;
		while(in.hasNext()) {
			string = in.nextLine();
			System.out.println(string);
		}
	}
}
