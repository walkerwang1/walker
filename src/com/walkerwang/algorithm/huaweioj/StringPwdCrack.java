package com.walkerwang.algorithm.huaweioj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringPwdCrack {
	public static void main(String[] args) {
		String str = "ZUANzhi1987";
		String result = codebreak(str);
		System.out.println(result);
	}
	
	/**
	 * 1-通过字符串过滤每个字符
	 */
	public static String codebreak(String str){
		if (str.length() == 0) {
			return null;
		}
		String result = "";
		String filternum = "1234567890";
		String filterUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String filterLower = "abcdefghijklmnopqrstuvwxyz";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("abc", 2);
		map.put("def", 3);
		map.put("ghi", 4);
		map.put("jkl", 5);
		map.put("mno", 6);
		map.put("pqrs", 7);
		map.put("tuv", 8);
		map.put("wxyz", 9);
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			//大写
			if (filterUpper.indexOf(ch) != -1) {
				if (ch == 'Z') {
					ch = 'A';
				}else{
					ch += 1;
				}
				result += (ch+"").toLowerCase();
			}
			//小写
			if(filterLower.indexOf(ch) != -1){
				Set<Map.Entry<String, Integer>> set = map.entrySet();
				Iterator<Map.Entry<String, Integer>> iter = set.iterator();
				while(iter.hasNext()){
					Map.Entry<String, Integer> element = iter.next();
					if (element.getKey().indexOf(ch) != -1) {
						result += element.getValue();
						break;
					}
				}
			}
			//数字
			if(filternum.indexOf(ch) != -1){
				result += ch;
			}
		}
		return result;
	}
	
	/*
	 * 2-通过字符的值
	 */
	public static String codebreak2(String str){
		char[] ch = str.toCharArray();
		for(int i=0; i<ch.length; i++){
			/**
			 * '0'->48
			 * '9'->57
			 */
			//大写
			
			//小写
			
			//数字
		}
		return null;
	}
}
