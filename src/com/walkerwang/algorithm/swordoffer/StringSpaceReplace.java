package com.walkerwang.algorithm.swordoffer;

public class StringSpaceReplace {
	public static void main(String[] args) {
//		�滻�ո�
		StringBuffer str = new StringBuffer("are you ok?");
		System.out.println(replaceSpace(str));
	}
	
	/**
	 * http://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
	 * �滻�ո�
	 * @param str
	 * @return
	 */
	public static String replaceSpace(StringBuffer str){
		//1
//		return  (str.toString()).replaceAll(" ", "%20");			
		
		//2
		if(str == null){
			return null;
		}
		for(int i=0; i<str.length(); ++i){
			char ch = str.charAt(i);
			if(ch == ' '){
				str.replace(i, i+1, "%20");
			}
		}
		return str.toString();
	}
}
