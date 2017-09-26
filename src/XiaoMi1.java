import java.math.BigInteger;
import java.util.Scanner;

public class XiaoMi1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			if (n < 0) { // 负数 退出循环
				break;
			}
			BigInteger ans = BigInteger.ONE;
			for (int i = 1; i <= n; i++) {
				ans = ans.multiply(BigInteger.valueOf(i));
			}
			System.out.println(ans);
		}
	}
}
