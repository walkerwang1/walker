package day.month9;

public class Day13 {

	public static void main(String[] args) {
		Day13 day13 = new Day13();
		int n = 13;
		day13.numOf1(n);
	}
	
	public void numOf1(int n) {
		int count = 0;
		for(int i = 1; i <= n; i++) {
			System.out.println(i);
			String str = Integer.toString(i);
			if (str.contains("1")) {	//i中包含1则转换成字符数组
				char[] chs = str.toCharArray();
				for(int j = 0; j < chs.length; j++) {
					if (chs[j] == '1') {
						count++;
					}
				}
			}
		}
		System.out.println("次数：" + count);
	}
}
