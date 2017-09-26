import java.util.Scanner;

public class XiaoMi2 {

	public static void main(String[] args) {
		
		/*
		 * 
		 */
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String[] str = in.nextLine().split(" ");
			String text = str[0];
			String pattern = str[1];
			boolean flag = true;
			char[] chs2 = pattern.toCharArray();
			for(int i = 0; i < chs2.length; i++) {
				if (text.indexOf(chs2[i]) < 0 ) {
					System.out.println((-1) + " " + (-1));
					flag = false;
				}
			}
			
			if (flag == false) {
				continue;
			}
			
			int direct_index = text.indexOf(pattern);
			if ( direct_index > 0) {
				System.out.println(direct_index + " " + (direct_index + pattern.length()-1));
				flag = false;
			}
			if (flag == false) {
				continue;
			}
			
			int[] start = new int[text.length()];
			for(int j = 0; j < text.length(); j++) {
				if (text.charAt(j) == chs2[0]) {
					start[j] = chs2[0];
				}
			}
			
			int n = 0;
			int start_index = text.indexOf(chs2[n++]);	//第一个字符已匹配
			int i = start_index;
			while(i < text.length()) {
				char ch = text.charAt(i);
				if (ch == chs2[n]) {
					n++;
					if (n >= chs2.length) {
						break;
					}
					i++;
				} else{
					i++;
				}
			}
			if (start_index < i && i < text.length()) {
				System.out.println(start_index + " " + i);
			}
		}
	}
}
