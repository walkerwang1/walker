package day.month9;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
	public static void main(String[] args) {
		Day2 day2 = new Day2();
		
//		String A = "wangkang";
//		String B = "wangkang";
//		int pos =day2.isSubstring(A, B);
////		System.out.println(pos);
//		
//		int[] arr = {1,2,4,8,16,32,64,128};
//		int n = 111;
//		day2.getSum(arr, n);;
//		
//		String str = "123jdiojfr kdopefk34n5j67AMMJIRJn";
//		day2.cntStr(str);
		
		day2.continueNum(15);
	}
	
	/**
	 * 1,2,4,8,32,64,128，可以表达1-255之间的所有数，
	 * 在该范围传进去任意一个数，结果输出，是有谁得到这个数，比如 传进去13，输出13 = 1+4+8
	 */
	public void getSum(int[] arr, int n) {
		if (n < 1 || n > 255) {
			return;
		}
		List<Integer> list = new ArrayList<>();
		int m = n;
		int i = arr.length - 1;
		while (i >= 0) {
			if (n == arr[i]) {
				list.add(arr[i]);
				break;
			}
			if (n < arr[i]) {
				i--;
				continue;
			}
			list.add(arr[i]);
			n = n -arr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(m + "=");
		for(int j = list.size()-1; j >=0; j--) {
			sb.append(list.get(j) + "+");
		}
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
	}
	
	/*
	 * 统计一个字符串中所有的数字，大小写字母，和其他字符，并看看能否改进
	 */
	public void cntStr(String A) {
		String filterA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String filterB = "abcdefghijklmnopqrstuvwxyz";
		String filterC = "0123456789";
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		
		for(int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (filterA.indexOf(ch) > 0) {
				countA++;
			} else if (filterB.indexOf(ch) > 0) {
				countB++;
			} else if (filterC.indexOf(ch) > 0) {
				countC++;
			} else {
				countD++;
			}
		}
		System.out.println("大写：" + countA + ";" + "小写：" + countB + ";" + ""
				+ "数字：" + countC + ";" + "其他：" + countD);
	}
	

	/*
	 * 子串匹配
	 * @return 返回子串B在串A中的位置
	 */
	public int isSubstring(String A, String B) {
		if (A.length() < B.length()) {
			return -1;
		}
		if (B.equals("")) {
			return 0;
		}
		
		char[] chA = A.toCharArray();
		char[] chB = B.toCharArray();
		int lenA = chA.length;
		int lenB = chB.length;
		
		for(int i = 0; i <= lenA - lenB; i++) {
			int k = i;
			int j = 0;
			while(true) {
				if (chA[k] == chB[j]) {
					k++;
					j++;
				} else {
					break;
				}
				if (j == lenB - 1) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/*
	 * 给定一个数，记录所有连续整数的和等于它的计算方式
	 * 15 = 1+2+3+4+5
	 * 15 = 3+4+5
	 * 15 = 7+8
	 */
	public void continueNum(int n) {
		int i = 1;
		while ( i <= n/2) {		//只需要比较到从中间值开始即可
			int k = i;		//关键k，记录求和到哪一个值
			int sum = 0;
			while(sum < n) {
				sum += k++;
				if (sum > n) {		//判断和是否已经超过n
					continue;
				}
				if (sum == n) {
					//输出[i,k-1]
					System.out.print(n + "=");
					for(int j = i; j < k; j++) {
						if (j == k-1) {
							System.out.print(j);
						} else {
							System.out.print(j + "+");
						}
					}
					System.out.println();
				}
			}
			i++;
		}
		if (i > n/2) {
			System.out.println(-1);
		}
	}
}
