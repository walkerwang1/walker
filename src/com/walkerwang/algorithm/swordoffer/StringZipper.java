package com.walkerwang.algorithm.swordoffer;

public class StringZipper {

	public static void main(String[] args) {
		String iniString = "wwangkkkkkkkk";
		System.out.println("ԭ�ַ���:"+ iniString+"(����"+iniString.length()+")");
		String resultStr = zipString(iniString);
		System.out.println("���:"+ resultStr);
	}
	
	/**
	 * ����ʱ�䣺49ms
		ռ���ڴ棺809k
	 */
	public static String zipString(String iniString) {
		if (iniString == null || iniString.length() == 0) {
			return null;
		}
		int iniLen = iniString.length();
		StringBuilder sb = new StringBuilder();
		int low, high;
		low = high = 0;
		char lowCh;
		while(low < iniLen){
//			high = low;
			lowCh = iniString.charAt(low);
			while(high < iniLen && lowCh == iniString.charAt(high)){
				high++;
			}
			sb.append(lowCh);
			sb.append(high-low);
			low = high;
		}
		int resLen = sb.length();
		System.out.println("ѹ����"+sb +"(����"+sb.length()+")");
		if(resLen >= iniLen)
			return iniString;
		return sb.toString();
	}
}
