package com.walkerwang.algorithm.bigcompany;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        String str;
        while(cin.hasNextInt())
        {
            str = cin.nextLine();
            String[] strs = str.split(" ");
            int len = strs.length;
            int N = Integer.parseInt(strs[len-1]);
            int M = len-1;
            int[] arr = new int[M];
            for(int i=0;i<M; i++) {
            	arr[i] = Integer.parseInt(strs[i]);
            }
            
            System.out.println(count(arr, N));
        }
    }
    
    public static int count(int[] arr, int money){
    	int count = 0;
    	Arrays.sort(arr);	//arr升序
    	if(arr[0] > money) {
    		return -1;
    	}
    	for(int i=arr.length-1; i>=0; i--){
    		if (arr[i] == money) {
				return 1;
			} else {
				if(arr[i] < money) {
					money -= arr[i];
					count++;
					i++;
				}
			}
    	}
    	if(money == 0) {
    		return count;
    	}else {
    		return -1;
    	}
    	
    }
}
