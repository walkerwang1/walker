package com;

import java.util.Scanner;

/**
 * 十进制数转为任意进制数（考虑了小数点）
 * 
 * @author walkerwang
 *
 */
public class DecimalToNbinary {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			String string = scanner.nextLine();
			String[] strs = string.split(" ");
			double input = Double.valueOf(strs[0]);
			int n = Integer.valueOf(strs[1]);
			System.out.println(decimal2Binary(input, n));
		}
	}
	
	public static String decimal2Binary(double value, int n){
        int in = (int) value;
        double r = value - in;

        StringBuilder stringBuilder = new StringBuilder();
        int remainder = 0;
        int quotient = 0;
        while (in != 0) {
            quotient = in / n;
            remainder = in % n;
            stringBuilder.append(remainder);
            in = quotient;
        }
        stringBuilder.reverse();
        stringBuilder.append(".");

        // 将小数部分转化为二进制
        int count = 32; // 限制小数部分位数最多为32位，如果超过32为则抛出异常
        double num = 0;
        while (r > 0.0000000001) {
            count--;
            if (count == 0) {
            }
            num = r * n;
            if (num >= 1) {
                stringBuilder.append(1);
                r = num - 1;
            } else {
                stringBuilder.append(0);
                r = num;
            }
        }
        String res = String.valueOf(value);
        if (res.substring(res.length()-1) == "0" ) {
        	return stringBuilder.toString();
		}else {
			return stringBuilder.toString().substring(0,stringBuilder.toString().length()-1);
		}
        
    }
}
