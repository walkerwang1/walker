
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TouTiao01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in

		);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int c = scan.nextInt();
		int color[] = new int[c + 1];
		int v[][] = new int[n][c + 1];
		for (int i = 0; i < n; i++) {
			int num = scan.nextInt();
			Arrays.fill(v[i], 0);
			for (int j = 0; j < num; j++) {
				int tempColor = scan.nextInt();
				v[i][tempColor] = 1;
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= c; j++) {
				if (set.contains(j))
					continue;
				color[j] += v[i][j];
				if (i - m >= 0) {
					color[j] -= v[i - m][j];
				}
				if (color[j] > 1) {
					set.add(j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= c; j++) {
				if (set.contains(j))
					continue;
				color[j] += v[i][j];
				color[j] -= v[i + n - m][j];
				if (color[j] > 1) {
					set.add(j);
				}
			}
		}
		System.out.println(set.size());
	}

}
