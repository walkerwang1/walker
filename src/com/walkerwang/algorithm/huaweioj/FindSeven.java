package com.walkerwang.algorithm.huaweioj;
import java.util.Scanner;

public class FindSeven {
	 
	    public static void main(String args[]){
	     	Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
//	     	int n = 80;
	        int count = 0;
	        StringBuilder sBuilder = new StringBuilder();
	        for(int val=1; val<=n; val++){
	        		String str = String.valueOf(val);
	         	   if(val%7 == 0 || str.indexOf('7')>-1){
	                   sBuilder.append(val+" ");
	                   count++;
	               }
	        }
	        System.out.println(sBuilder.toString());
	        System.out.println(count);
	    }
}
