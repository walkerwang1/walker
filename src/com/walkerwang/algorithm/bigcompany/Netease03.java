package com.walkerwang.algorithm.bigcompany;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
while(!Q.empty())              //队列不空，执行循环

{

    int x=Q.front();            //取出当前队头的值x

    Q.pop();                 //弹出当前队头

    Q.push(x);               //把x放入队尾

    x = Q.front();              //取出这时候队头的值

    printf("%d\n",x);          //输出x

    Q.pop();                 //弹出这时候的队头

}

做取出队头的值操作的时候，并不弹出当前队头。
小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正] 
输入描述:
第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。


输出描述:
对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.

输入例子:
4
1
2
3
10

输出例子:
1
2 1
2 1 3
8 1 6 2 10 3 7 4 9 5
 * @author walkerwang
 *
 */
public class Netease03 {
	public static LinkedList<Integer> linkedList;
	public static int[] ret = new int[10000];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = 1;
		while(i <=n ) {
			int x = in.nextInt();
			get_arr(x);
			i++;
		}
	}

	public static void get_arr(int x) {
		linkedList = new LinkedList<Integer>();
		for (int i = 0; i < x; i++) {
			linkedList.addLast(i + 1);
		}
		int sequence = 1;
		while (!linkedList.isEmpty()) {
			int xx = (int) linkedList.getFirst();
			linkedList.removeFirst();
			linkedList.addLast(xx);
			xx = (int) linkedList.getFirst();
			ret[xx - 1] = sequence;
			linkedList.removeFirst();
			sequence++;
		}
		
		for(int i = 0; i < x; i++) {
			System.out.print(ret[i]);
			if (i != x-1) {
				System.out.print(" ");
			} else {
				System.out.print("\n");
			}
		}
	}
}
