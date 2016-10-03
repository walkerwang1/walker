package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringEncrypt {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String key = scanner.nextLine();
		String data = scanner.nextLine();
		key = key.replaceAll(" ", "");
		String enctypt = encrypt(key, data);
		System.out.println(enctypt);
	}

	public static String encrypt(String key, String data) {
		String encrypt = "";
		char[] chA = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String strFilter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] chB = new char[chA.length];

		// 如果秘钥存在重复的字母就匹配不当
		int index;
		int count = 0;
		for (index = 0; index < key.length(); index++) {
			String strB = "";
			for (int i = 0; i < count; i++) {
				strB += chB[i];
			}
			char ch = (key.charAt(index) + "").toUpperCase().charAt(0);
			if (strB.indexOf(ch) < 0) {
				chB[count] = ch;
				count++;
			}
		}
		for (int i = count; i < chB.length; i++) {
			String strB = "";
			for (int j = 0; j < chB.length; j++){
				strB += chB[j];
			}
			for (index = 0; index < strFilter.length(); index++) {
				char ch = strFilter.charAt(index);
				// 如果chB中不包含ch，则添加到chB中
				if (strB.indexOf(ch) < 0) {
					chB[i] = ch;
					break;
				}
			}
		}
		String strA = "";
		String strB = "";
		System.out.println();
		for (int i = 0; i < chA.length; i++) {
			System.out.print(chA[i] + " ");
			strA += chA[i];
		}
		System.out.println();
		for (int i = 0; i < chA.length; i++) {
			System.out.print(chB[i] + " ");
			strB += chB[i];
		}

		 System.out.println();
		// 此时对应规则已确定，对data进行加密
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			if (ch >= 65 && ch <= 90) { // 大写
				index = strA.indexOf((ch + "").toUpperCase().charAt(0));
				encrypt += chB[index];
			} else if (ch >= 97 && ch <= 122) {
				index = strA.indexOf((ch + "").toUpperCase().charAt(0));
				encrypt += (chB[index] + "").toLowerCase().charAt(0);
			} else {
				encrypt += ch;
			}
		}
		return encrypt;
	}
}
