package com.walkerwang.algorithm.huaweioj;

import java.util.Scanner;

public class StringLearnEnglish {
	private final static String WORDS[] = { "", "one", "two", "three", "four", "five", // 1-5
			"six", "seven", "eight", "nine", "ten", // 6-10
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", // 11-15
			"sixteen", "seventeen", "eighteen", "nineteen", "twenty", // 16-20
			"thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"// 30-90
	};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		long num = scanner.nextLong();
		long num = 1_000_000;
		System.out.println(parse(num));
		scanner.close();
	}

	private static String parse(long num) {
//		if (num < 0 ) {
//			return "error";
//		}
//		StringBuilder sBuilder = new StringBuilder();
//		String str = num +"";
//		int length = str.length();
//		if(length <= 3){  //百、十、个
//			
//		}else if(length <= 7){//1000000 百万
//			
//		}
//		return sBuilder.toString();
		if (num < 0) {
			return "error";
		}else if (num < 20) { 
			return WORDS[(int) num];
		} else if (num < 100) {
			if (num % 10 == 0) {
				return WORDS[(int) (20 + (num - 20) / 10)]; 
			} else {
				return parse(num / 10 * 10) + " " + parse(num % 10);
			}
		} else if (num < 1_000) { 
			if (num % 100 == 0) {
				return parse(num / 100) + " hundred";
			} else {
				return parse(num / 100) + " hundred and " + parse(num % 100);
			}
		} else if (num < 1_000_000) { 
			if (num % 1_000 == 0) {
				return parse(num / 1_000) + " thousand";
			} else {
				return parse(num / 1_000) + " thousand " + parse(num % 1_000);
			}
		} else if (num < 1_000_000_000) { 
			if (num % 1_000_000 == 0) {
				return parse(num / 1_000_000) + " million";
			} else {
				return parse(num / 1_000_000) + " million " + parse(num % 1_000_000);
			}
		} else if (num < 10_000_000_000L) { 
			if (num % 1_000_000_000 == 0) {
				return parse(num / 1_000_000_000) + " billion";
			} else {
				return parse(num / 1_000_000_000) + " billion " + parse(num % 1_000_000_000);
			}
		} else {
			return "error";
		}
	}
}
