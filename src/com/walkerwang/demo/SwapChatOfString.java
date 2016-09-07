package com.walkerwang.demo;

public class SwapChatOfString {
	
	public static void main(String[] args) {
		
		String str = new String("abcdefg");	//交换b、e
		
		char tmp1 = str.charAt(1);	//b
		char tmp2 = str.charAt(4);	//e
		
		String str1 = str.replace(tmp2, tmp1);
		System.out.println(str1);
		str = str1.replaceFirst(String.valueOf(tmp1), String.valueOf(tmp2));
		
//		StringBuffer newStr = new StringBuffer();
//		System.out.println(str.substring(0, 1));	//a
//		System.out.println(str.substring(4, 4+1));	//e
//		System.out.println(str.substring(1+1, 4));	//cd
//		System.out.println(str.substring(1, 1+1)); 	//b
//		System.out.println(str.substring(4+1, str.length()));	//fg
//		
//		newStr.append(str.substring(0, 1)).append(str.substring(4, 4+1)).append(
//				str.substring(1+1, 4)).append(str.substring(1, 1+1)).append(str.substring(4+1, str.length()));
		
		System.out.println(str);
//		System.out.println(newStr.toString());
	}
	
}
