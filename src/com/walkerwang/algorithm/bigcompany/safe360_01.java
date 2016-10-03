package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

/*密码锁
	题目描述：
	作为一名新手特工，小B接受了大量的秘密间谍训练。检验她学业成就的时刻到了，她被派到一个基地去执行一项秘密任务，窃取该基地中一个尖端工艺的设计流程。
	
	经过一系列惊险的过程，小B已经成功的抵达了目标区域。遗憾的是，目标区域高墙围挡，墙上还有电网和红外安保机制，她发现只能通过大门进入。好在她已经成功的接近了大门，成功正在向她招手。大门是无人值守的，由电子密码组合锁控制。几分钟前，她发现一名工作人员在终端上输入过密码，并打开了门进入其中。电子密码锁是一个方形的3x3数字键盘，上面有从1到9的数字按键。
	
	小B推测密码是由不同的字符构成，且是沿按键中心对称的。她的热传感器能够探测上次按键的余温。她希望验证一下密码是否是沿按键中心对称，这样就可以极大的减少她尝试的次数，你能帮她吗？
	输入
	输入中有多组测试数据。每组测试数据由3x3的矩阵构成，其中“X”表示按下的按键，“.” 表示未按下的按键。矩阵中可能不包含“X”，也可能没有“.”。
	输出
	对每组测试数据，在单独的行中输出结果，若密码是沿中心对称的，输出YES，否则输出NO。
	
	样例输入
XX.
...
.XX
X.X
X..
...
	样例输出
	YES
	NO

 */
public class safe360_01 {
	public static void main(String[] args) {
		int row = 3;
		int colum = 3;
		boolean flag = false;
		char[][] arr = new char[row][colum];
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			for (int i = 0; i < row; i++){
//				for (int j = 0; j < colum; j++) {
					String str = scanner.next();
					arr[i][0] = str.charAt(0); 
					arr[i][1] = str.charAt(1); 
					arr[i][2] = str.charAt(2); 
//				}
			}

			for (int i = 0; i < row / 2 + 1; i++) {
				for (int j = 0; j < colum / 2 + 1; j++) {
					if (arr[i][j] != arr[row - i - 1][colum - j - 1]) {
						flag = true;
						System.out.println("NO");
						break;
					}
				}
				if (flag == true) {
					break;
				}
			}
			if (flag == false) {
				System.out.println("YES");
			}
		}
	}
}
