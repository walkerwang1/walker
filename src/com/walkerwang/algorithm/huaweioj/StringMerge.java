package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringMerge {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String str1 = scanner.nextLine();
//		String str2 = scanner.nextLine();
		 String str1 = "dec1";
		 String str2 = "fab2";
		 /**D834B5F7
		  * 奇偶排序后：b1cadef
			D835B7F
		  */
		System.out.println(merge(str1, str2));

	}

	public static String merge(String str1, String str2) {
		String str = str1 + str2;
		char[] chs = str.toCharArray();
		String result = "";
		// 对奇偶位的字符排序
		for (int i = 1; i <= chs.length / 2; i++) {
			for (int j = 0; j < chs.length - 2; j = j + 2) {
				if (chs[j] > chs[j + 2]) {
					char tmp = chs[j];
					chs[j] = chs[j + 2];
					chs[j + 2] = tmp;
				}
			}
			for (int j = 1; j < chs.length - 2; j = j + 2) {
				if (chs[j] > chs[j + 2]) {
					char tmp = chs[j];
					chs[j] = chs[j + 2];
					chs[j + 2] = tmp;
				}
			}
		}

		// str已排序
		System.out.print("奇偶排序后：");
		System.out.println(chs);
		
		System.out.println(chs.length);
		for (int i = 0; i < chs.length; i++) {
			char ch = chs[i];
			String binaryStr = "";
			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
				ch = (chs[i] + "").toLowerCase().charAt(0);
				binaryStr = Integer.toBinaryString(ch - 87);
				StringBuilder sb = new StringBuilder(binaryStr).reverse();
				String hexStr = Integer.toHexString(Integer.parseInt(sb.toString(), 2));
				result += hexStr;
			} else if(ch>=48 && ch<=57){
				binaryStr = Integer.toBinaryString(ch-48);
				if(binaryStr.length() < 4){
					int len = 4 - binaryStr.length();
					for(int j=0; j<len; j++){
						binaryStr = "0" + binaryStr;
					}
				}
				// System.out.println(binaryStr);
				StringBuilder sb = new StringBuilder(binaryStr).reverse();
				// System.out.println(sb.toString());
				String hexStr = Integer.toHexString(Integer.parseInt(sb.toString(), 2));
				// System.out.println(hexStr);
				result += hexStr;
			}else {
				result += ch;
			}
		}

		System.out.println("转化后结果:"+ result);

		String newResult = "";
		// 对结果进行处理，小写->大写
		for (int i = 0; i < result.length(); i++) {
			char ch = result.charAt(i);
			if (ch >= 48 && ch <= 57) {
				newResult += ch;
			}else if (ch >= 97 && ch <= 122) {
				newResult += (ch + "").toString().toUpperCase();
			}else {
				newResult += ch;
			}
		}
		return newResult;
	}

}
