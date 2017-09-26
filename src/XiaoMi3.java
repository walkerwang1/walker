import java.util.Scanner;

public class XiaoMi3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
//			System.out.println(getNum(n));
			System.out.println(JumpFloor(n));
		}
	}
	
	public static int JumpFloor(int n) {
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else {
            return JumpFloor(n-1) + JumpFloor(n-2);
        }
    }

	public static int getNum(int i) {
		int num = 0;
		int r = 0;
		if (i > 2) {
			num = getNum(i - 1) + getNum(i - 2);
			return num;
		} else if (i == 1) {
			r = 1;
		} else if (i == 2) {
			r = 2;
		}
		return r;
	}
}
