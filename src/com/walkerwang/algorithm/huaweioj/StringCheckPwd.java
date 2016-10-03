package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringCheckPwd {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// String inputString = "021Abc9000 021Abc9Abc1 021ABC9000 021$bc9000";
		while (scanner.hasNext()) {
			String inputString = scanner.nextLine();
			String[] strs = inputString.split(" ");
			for (int i = 0; i < strs.length; i++) {
				String string = strs[i];
				int length = getLen(string);
				if (length > 8) {
					// 长度大于8则判断密码是否至少有3中类别
					int flag = getNumOfType(string);
					if (flag >= 3) {
						// 判断是否有长度大于2的重复子串
						boolean isRepeated = isRepeatedString(string);
						if (!isRepeated) {
							System.out.println("OK");
						} else {
							System.out.println("NG");
							continue;
						}
					} else {
						System.out.println("NG");
						continue;
					}
				} else {
					System.out.println("NG");
					continue;
				}
			}
		}
	}

	//获取字符串的长度	
	public static int getLen(String str){
		return str.length();
	}
	
	//判断密码是否至少包含3种类型
	public static int getNumOfType(String str){
		int flag = 0;
		int flag1, flag2, flag3, flag4;
		flag1 = flag2 = flag3 = flag4 = 0;
		for (int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j);
			if (ch >= 65 && ch <= 90) {
				// 大写字母
				if (flag1 == 0)
					flag1++;
			} else if (ch >= 97 && ch <= 122) {
				// 小写字母
				if (flag2 == 0)
					flag2++;
			} else if (ch >= 48 && ch <= 57) {
				// 数字
				if (flag3 == 0)
					flag3++;
			} else {
				// 其他
				if (flag4 == 0)
					flag4++;
			}
		}
		flag = flag1 + flag2 + flag3 + flag4;
		return flag;
	}
	
	//判断是否有长度大于2的重复子串
	public static boolean isRepeatedString(String str) {
		Boolean isRepeadted = false;
		int length = str.length();
		for (int len = 3; len < length; len++) {
			for (int i = 0; i < length - len; i++) {
				String subStrA = str.substring(i, i + len);
				for (int j = i + 1; j < length - len + 1; j++) {
					String subStrB = str.substring(j, j + len);
					if (subStrA.equals(subStrB)) {
						isRepeadted = true;
						break;
					}
				}
			}
		}
		return isRepeadted;
	}
}