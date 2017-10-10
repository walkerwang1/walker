package day.month9;

import java.util.ArrayList;

public class Day8 {
	
	private static ArrayList <Integer> list = new ArrayList<>();  
    public static void main(String[] args) {  
        int [] arr = {1,3,4,5,2};  
        int k = 3;    	//取k个数
        if(k > arr.length || arr.length <= 0){  
            return ;  
        }  
        combine(0 ,k ,arr);  
    }  
    public static void combine(int index,int k,int []arr) {  
        if(k == 1){  	//list中已经存在k-1个数
            for (int i = index; i < arr.length; i++) {  
                list.add(arr[i]);  
                System.out.println(list.toString());  
                list.remove((Object)arr[i]);  
            }  
        }else if(k > 1){  
            for (int i = index; i <= arr.length - k; i++) {  
                list.add(arr[i]);  	//添加arr[i]
                
                combine(i + 1,k - 1, arr);  //回溯
                
                list.remove((Object)arr[i]);  	//移除arr[i]
            }  
        }else{  
            return ;   
        }  
    }  
}
