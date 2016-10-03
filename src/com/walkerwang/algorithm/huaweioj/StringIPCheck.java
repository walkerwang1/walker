package com.walkerwang.algorithm.huaweioj;

public class StringIPCheck {
	public static void main(String[] args) {
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(System.in);
//		String mask = scanner.nextLine();
//		String ip1 = scanner.nextLine();
//		String ip2 = scanner.nextLine();
		String mask = "255.255.255.0";
		String ip1 = "192.168.0.254";
		String ip2 = "192.168.0.1";
		int result = checkNetSegment(mask, ip1, ip2);
//		System.out.println(result);
	}
	
	/* 
	* 功能: 判断两台计算机IP地址是同一子网络。 
	* 输入参数：    String Mask: 子网掩码，格式：“255.255.255.0”； 
	*               String ip1: 计算机1的IP地址，格式：“192.168.0.254”；
	*               String ip2: 计算机2的IP地址，格式：“192.168.0.1”；
	*               
	* 返回值：      0：IP1与IP2属于同一子网络；     1：IP地址或子网掩码格式非法；    2：IP1与IP2不属于同一子网络
	*/ 
	public static int checkNetSegment(String mask, String ip1, String ip2) 
	{     
		if (mask.equals("") || ip1.equals("") || ip2.equals("")) {
			return 0;
		}
		String maskBinary = decimalToBinary(mask);
		String ip1Binary = decimalToBinary(ip1);
		String ip2Binary = decimalToBinary(ip2);
	    /*在这里实现功能*/
	    return 0;
	}
	
	/**
	 * 十进制->二进制
	 * @param str
	 * @return
	 */
	static String decimalToBinary(String str){
		StringBuilder sBuilder = new StringBuilder();
		String[] strs = str.split("\\.");
		for(int i=0; i<strs.length; i++){
			int seg = Integer.parseInt(strs[i]);
			String binary = Integer.toBinaryString(seg);
			String result = "";
			//补全0
			if(binary.length()<8){
				int len = 8-binary.length();
				for(int j=0; j<len; j++){
					result += "0";
				}
			}
			binary = result + binary;
			sBuilder.append(binary);
			sBuilder.append(".");
		}
		return sBuilder.toString().substring(0, sBuilder.length()-1);
	}
	
	/**
	 * 二进制->十进制
	 * @param str
	 * @return
	 */
	static String binaryToDecimal(String str){
//		String decimal = Integer.valueOf(binary, 2).toString();
//		System.out.println(decimal);
		return "";
	}

	/**
	 * 判断mask和ip是否合法
	 * @param str
	 * @return
	 */
	static boolean checkMastAndIp(String str){
		//<=255
		return false;
	}
}
