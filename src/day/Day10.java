package day;

import java.util.ArrayList;
import java.util.List;

public class Day10 {

	public static void main(String[] args) {
		Day10 day10 = new Day10();
		String[] arr = new String[]{"-3.14", "0.7177", 
				"1586.23", "10000.0", "-587643.1", "12.34565"};
//		day10.duiqi(arr);
		System.out.println(Long.MAX_VALUE);
//		int n = 100;
		int size = 0;
		for(int i = 1; i <= 1000000; i++) {
			size += day10.qiken(i);
		}
		System.out.println(size);
	}
	
	/*
	 * 小数点对齐
	 */
	public void duiqi(String[] arr) {
		int max_len = 0;
		//确定小数点前面包含数字最多的数字
		for(int i = 0; i < arr.length; i++) {
			String str = arr[i];
			int index = str.indexOf(".");
			int pre_len = str.substring(0, index).length();
			if (pre_len > max_len) {
				max_len = pre_len;
			}
		}
		//添加空格
		for(int i = 0; i < arr.length; i++) {
			int index = arr[i].indexOf(".");
			for(int j = 1; j <= max_len - index; j++) 
				arr[i] = " " + arr[i];
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/*
	 * 齐肯多夫表示，菲波那切数列
	 */
	public int qiken(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		int len = 0;
		int next = list.get(0) + list.get(1);
		while(next <= n) {
			len = list.size();
			list.add(list.get(len-1) + list.get(len-2));
			len = list.size();
			next = list.get(len-2) + list.get(len-1);
		}
//		System.out.println(list);
		
		int count = 0;
		while(n != 0) {
			//找到第一个比n大的数
			int i = len-1;
			while(n < list.get(i)) {
				i--;
			}			
			count++;
			if (n == list.get(i)) {
				break;
			}
			n = n - list.get(i);
			/*for(int j = i; j < len-1; j++) {
				list.remove(j);
				len = list.size();
			}
			len = list.size();*/
		}
//		System.out.println(count);
		return count;
	}
}
