package day.month9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 如果正偶数N是2的幂，或者其所有不同的质因数恰好是连续质数，就被称为是可接受的。
	前十二个可接受数是2、4、6、8、12、16、18、24、30、32、36、48。
	如果N是可接受数，使得N+M为质数的最小整数M > 1就被称为N的伪幸运数。
	例如，N=630是可接受数，因为它是偶数，而且它所有不同的质因数为连续质数2、3、5、7。
	在631之后的下一个素数是641；因此，630的伪幸运数是M=11。
	同样可以看出，16的伪幸运数是3。
	找出所有小于109的可接受数N，分别求出其伪幸运数，并求所有不同的伪幸运数的和。
 */
public class Day6 {
	public static void main(String[] args) {
		Day6 day6 = new Day6();
		int n = 42;
		
//		boolean flag = day6.isContinousPrimeNum(n);
//		System.out.println(flag);
		
		Scanner in = new Scanner(System.in);
		int str1 = in.nextInt();
		int str2 = in.nextInt();
		System.out.println(str1);
		System.out.println(str2);
		
	}
	
	/*
	 * 判断一个数是否是2的幂：第一位是1，后面不包含1
	 */
	public boolean isEven(int n) {
		String str = Integer.toBinaryString(n);
		int a = Integer.valueOf(str.substring(0,1));
		String later_str = str.substring(1);
		int later = later_str.indexOf('1');
		return (a == 1) && (later < 0);
	}
	
	/*
	 * 判断一个数是否是2的幂,8(1000) 16(10000), 10000 & 01111 == 0.
	 */
	public boolean isEven2(int n) {
		return (n > 0) && ((n & (n-1)) == 0);
	}
	
	/*
	 * 判断一个数的质因数是否是连续质数
	 */
	public boolean isContinousPrimeNum(int n) {
		List<Integer> list = new ArrayList<>();
		boolean flag = true;
		int factor = 2;
		while(factor <= n) {
			if (n % factor == 0) {
				n = n / factor;
				if (!list.contains(factor)) {
					list.add(factor);
				}
			} else {
				//如果factor是质数，且list中不包含改数，则表示质因数不连续
				if (isPrimeNum(factor) && !list.contains(factor)) {
					flag = false;
					break;
				}
				factor++;
			}
		}
		System.out.println(list);
		return flag;
	}
	
	/*
	 * 判断一个数是否是质数
	 */
	public boolean isPrimeNum(int factor) {
		for (int i = 2; i < factor; i++){
            if(factor % i == 0){
                return false;
            }
            continue;
        }
        return true;
	}
}
