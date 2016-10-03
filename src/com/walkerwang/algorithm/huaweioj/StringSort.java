package com.walkerwang.algorithm.huaweioj;

public class StringSort {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String inputString = scanner.nextLine();
		String inputString = "s S a";
				//"A Famous Saying: Much Ado About Nothing (2012/8)";
		//A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8)
		String result = stringSort(inputString);
		System.out.println(result);
		String string = "a";
		char ch = string.toCharArray()[0];
		System.out.println(ch);
		/*&
		 * edcbaA
		 *BabA 输出：aABb
规则3：非英文字母的其它字符保持原来的位置。
    如，输入：By?e 输出：Be?y
		 */
	}
	
	//选择一种稳定的排序算法
	//这种排序不稳定 "s s a"
	public static String stringSort(String str){
		String result = "";
		if (str == null) {
			return null;
		}
		char[] chars = str.toCharArray();
		//冒泡排序
		for(int i=0; i<chars.length; i++)
		{
//			System.out.println(chars[i]);
			//ch1不为空，并且ch1是大写字母或小写字母
			if (chars[i] != ' ' && ((chars[i]>=65 && chars[i]<=90) || (chars[i]>=97 && chars[i]<=122))) {
				for(int j=i+1; j<chars.length; j++){
//					System.out.println(chars[j]);
					//ch2不为空，并且ch2是大写字母或小写字母
					if (chars[j] != ' ' && ((chars[j]>=65 && chars[j]<=90) || (chars[j]>=97 && chars[j]<=122))) {
						//ch1>ch2时交换（不区分大小写）
						//把ch1和ch2都转换成小写
//						System.out.println(chars[i]+" "+ chars[j]);
						char ch11 = (chars[i]+"").toLowerCase().charAt(0);
						char ch22 = (chars[j]+"").toLowerCase().charAt(0);
						if (ch11 > ch22) {
							char tmp;
							tmp = chars[i];
							chars[i] = chars[j];
							chars[j] = tmp;
						}
						//相同则按输入顺序
					}else{
						continue;
					}
//					System.out.println(chars);
				}
			}else{
				continue;
			}
//			System.out.println(chars);
			System.out.println();
		}
		for(int i=0; i<chars.length; i++)
			result += chars[i];
		return result;
	}
	
	/**
	 * public static String stringSort(String str){
		String result = "";
		if (str == null) {
			return null;
		}
		char[] chars = str.toCharArray();
		//冒泡排序
		for(int i=0; i<1; i++)
		{
			char ch1 = chars[i];
			System.out.println(ch1);
			//ch1不为空，并且ch1是大写字母或小写字母
			if (ch1 != ' ' && ((ch1>=65 && ch1<=90) || (ch1>=97 && ch1<=122))) {
				for(int j=i+1; j<chars.length; j++){
					char ch2 = chars[j];
					System.out.println(ch2);
					//ch2不为空，并且ch2是大写字母或小写字母
					if (ch2 != ' ' && ((ch2>=65 && ch2<=90) || (ch2>=97 && ch2<=122))) {
						//ch1>ch2时交换（不区分大小写）
						//把ch1和ch2都转换成小写
						System.out.println(ch1+" "+ ch2);
						char ch11 = (ch1+"").toLowerCase().charAt(0);
						char ch22 = (ch2+"").toLowerCase().charAt(0);
						if (ch11 > ch22) {
							char tmp;
							tmp = chars[i];
							chars[i] = chars[j];
							chars[j] = tmp;
						}
						//相同则按输入顺序
					}else{
						continue;
					}
//					System.out.println(chars);
				}
			}else{
				continue;
			}
			System.out.println(chars);
			System.out.println();
		}
		for(int i=0; i<chars.length; i++)
			result += chars[i];
		return result;
	}
	 */
}
