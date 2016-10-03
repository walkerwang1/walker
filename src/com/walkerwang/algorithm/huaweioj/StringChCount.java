package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringChCount {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int chCount, blankCount, numberCount, otherCount;
		// String str = "1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][";
		String str = scanner.nextLine();
		chCount = getEnglishCharCount(str);
		blankCount = getBlankCharCount(str);
		numberCount = getNumberCharCount(str);
		otherCount = getOtherCharCount(str);
		System.out.println(chCount);
		System.out.println(blankCount);
		System.out.println(numberCount);
		System.out.println(otherCount);
	}

	/**
	 * 统计出英文字母字符的个数。
	 * 
	 * @param str
	 *            需要输入的字符串
	 * @return 英文字母的个数
	 */
	public static int getEnglishCharCount(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 统计出空格字符的个数。
	 * 
	 * @param str
	 *            需要输入的字符串
	 * @return 空格的个数
	 */
	public static int getBlankCharCount(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ')
				count++;
		}
		return count;
	}

	/**
	 * 统计出数字字符的个数。
	 * 
	 * @param str
	 *            需要输入的字符串
	 * @return 英文字母的个数
	 */
	public static int getNumberCharCount(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 48 && ch <= 57)
				count++;
		}
		return count;
	}

	/**
	 * 统计出其它字符的个数。
	 * 
	 * @param str
	 *            需要输入的字符串
	 * @return 英文字母的个数
	 */
	public static int getOtherCharCount(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((!(ch == ' ')) && (!(ch >= 65 && ch <= 90)) && (!(ch >= 97 && ch <= 122)) && (!(ch >= 48 && ch <= 57)))
				count++;
		}
		return count;
	}
}
