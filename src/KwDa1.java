import java.util.Scanner;
import java.util.Stack;

public class KwDa1 {

	public static void main(String[] args) {
//		String str = "RRRL";
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'L' && stack.size() == 0) {
				stack.push(ch);
				continue;
			}
			if (ch == 'R') {
				stack.push(ch);
			}
			if (ch == 'L') {
				char ch_pop = stack.peek();
				if (ch_pop == 'L') {
					stack.push(ch);
					continue;
				}
				while (ch_pop == 'R') {
					if (stack.size() != 0) {
						stack.pop();
						if (stack.size() != 0) {
							ch_pop = stack.peek();
						} else {
							ch_pop = 'a';
						}
					} else{
						continue;
					}
				}
				if (ch_pop != 'R') {
					stack.push('R');
				}
			}
		}
		System.out.println(stack.size());
	}
}
