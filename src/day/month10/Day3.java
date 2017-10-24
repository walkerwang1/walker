package day.month10;

public class Day3 {
	
	int[] fib = new int[100];	//记录斐波那契数列值
	
	int count = 0;		//记录上阶梯种数

	public static void main(String[] args) {
		Day3 day3 = new Day3();
		
		int a = 5;	// 101
		int b = 6;	// 110
//		System.out.println(a^b);	//异或
//		System.out.println(a&b);	//与 
		day3.add(a, b);
	}
	
	int add(int a,int b)  
	{  
	    int sum;  
	    int carry ;  
	    while(b != 0)  
	    {  
	         sum = a ^ b;   
	         carry = (a & b) << 1;  //左移
	         a = sum;  
	         b = carry;  
	     }  
	     return a;  
	}  

	/*
	 * 1-斐波那契数列——递归
	 */
	public int fibonacci(int i) {
		if (i == 0) 
			return 0;
		if (i == 1) 
			return 1;
		return fibonacci(i-1) + fibonacci(i-2);
	}
	
	/*
	 * 1-斐波那契数列——动态规划，保存中间值
	 */
	public int fibonacci2(int i) {
		if (i == 0) 
			return 0;
		if (i == 1) 
			return 1;
		if (fib[i] != 0) return fib[i];
		fib[i] = fibonacci(i-1) + fibonacci(i-2);
		return fib[i];
	}
	
	/*
	 * 2-上阶梯——递归
	 */
	public int countStep(int n) {
		if (n == 1) 
			return 1;
		if (n == 2) 
			return 2;
		return countStep(n-1) + countStep(n-2);
	}
	
	/*
	 * 3-字符串的所有排列组合——递归
	 */
	
}

