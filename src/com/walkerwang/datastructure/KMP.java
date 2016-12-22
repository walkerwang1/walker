package com.walkerwang.datastructure;

/**
 * 字符串匹配算法
 * @author walkerwang
 *
 */
public class KMP {
	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "cde";
		System.out.println(violentMatch(str1, str2) > 0 ? "匹配成功" : "匹配失败");
	}
	
	/**
	 * 暴力求解
	 * @param str1
	 * @param str2
	 * @return
	 */
	static int violentMatch(String str1, String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int len1 = chs1.length;
		int len2 = chs2.length;
		int i = 0;
		int j = 0;
		while(i < len1 && j < len2) {
			if (chs1[i] == chs2[j]) {
				i++;
				j++;
			} else {
				//chs1[i] != chs2[j]; 匹配失败
				i = i - j + 1;	//i退回走过的字符步数
				j = 0;		//j从0开始
			}
		}
		if (j == len2) {
			return i - j;	//返回子串str2在父串str1中的位置
		} else{
			return -1;
		}
	}
	
	
}
