package com.walkerwang.algorithm.huaweioj;
import java.util.Scanner;

public class StringCalCaptical {
		public static void main(String args[]){
			Scanner scanner = new Scanner(System.in);
	        String str = scanner.nextLine();
	        System.out.println(calCaptial(str));
		}
	    
	    public static int calCaptial(String str){
	        int count = 0;
	    	if(str.equals(" "))
	            return count;
	        for(int i=0; i<str.length(); i++){
	         	char ch = str.charAt(i);
	            if(ch>=65 && ch<=90)
	                count++;
	        }
	        return count;
	    }
}
