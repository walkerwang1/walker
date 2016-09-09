package com.walkerwang.algorithm.bigcompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 有趣的数字
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？

	输入描述:
	
	 输入包含多组测试数据。
	
	 对于每组测试数据：
	
	 N - 本组测试数据有n个数
	
	 a1,a2...an - 需要计算的数据
	
	 保证:
	
	 1<=N<=100000,0<=ai<=INT_MAX.
	
	输出描述:
	
	对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
	
	输入例子:
	6
	45 12 45 32 5 6
	
	输出例子:
	1 2

 *
 */
public class Tecent02 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
//		int n = 6;
//		int[] arr = {45, 12, 45, 32, 5, 6};
//		45 12 45 32 5 6
		int n = 0;
		int[] arr = {};
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = scanner.nextInt();
			
			Arrays.sort(arr);	//对arr增序排序
            //如果数组中的值全相同，直接两两组合
            if(arr[0] == arr[n-1]){
                int count = (n*(n-1))/2;
                System.out.println(count + " " + count);
                continue;	//直接进入下一次while循环
            }
            
            //用map统计每个数字出现的次数
            Map<Integer, Integer> map = new TreeMap<>();	//TreeMap是有序的，如果用HashMap，原来的排序顺序就打乱了
            for(int i=0; i<n; i++){
            	if (map.containsKey(arr[i])) {	//如果包含key，直接获取次数+1
					map.put(arr[i], map.get(arr[i])+1);
				}else{
					map.put(arr[i], 1);
				}
            }
            
            //遍历map
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            Iterator<Map.Entry<Integer, Integer>> iter = set.iterator();
            while(iter.hasNext()) {
            	Map.Entry<Integer, Integer> entry = iter.next();
            	System.out.println(entry.getKey() + ":" + entry.getValue());
            }
            
            //求最小差个数（有问题）
            int minCount = 0;
            if(map.size() == n) {	//说明没有重复元素(机智)
            	//如果这个minValue是最小差，那这个最小差的一次就没有计入minCount，例子 1 2 3 4 5
            	int minValue = Integer.MAX_VALUE;	
            	for(int i=1; i<n; i++) {
            		int tmp = Math.abs(arr[i] - arr[i-1]);
            		if(tmp == minValue){
            			minCount++;
            		}else if(tmp < minValue) {
            			minValue = tmp;
            			minCount = 1;
            		}
            	}
            }else {	//有重复元素，则最小差为0，统计map中数字次数出现最多的，求得对数n*(n-1)/2
            	for(Integer key : map.keySet()) {
            		int val = map.get(key);
            		if (val > 1) {
						minCount += (val*(val-1))/2;
					}
            	}
            }
            
            //求最大差个数
            int maxCount = 0;
            //map的keyset存放到List中，keySet的顺序还是没变，TreeMap、ArrayList都是有序的
            List<Integer> keyset = new ArrayList<>(map.keySet());
            int val1 = map.get(keyset.get(0));		//最小值个数
            int val2 = map.get(keyset.get(keyset.size()-1));	//最大值个数
            maxCount = val1 * val2;
            
            //遍历map中keyset
            Iterator<Integer> keysetList = keyset.iterator();
            while(keysetList.hasNext()){
            	System.out.println(keysetList.next());
            }
            
            System.out.println(minCount + " " +maxCount);
            
			
            /*这种方法也行，不过超时了，效率低
			int value;
			int minValue = Integer.MAX_VALUE;
			int minCount = 0;
			int maxValue = Integer.MIN_VALUE;
			int maxCount = 0;
			//找到最小差
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(i != j){
						value = arr[i] - arr[j];
						//最小差
						if(value >= 0 && value < minValue){
							minValue = value;
						}
						//最大差
						if(value >= 0 && value > maxValue){
							maxValue = value;
						}
					}
				}
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(i != j){
						value = arr[i] - arr[j];
						//最小差对数
						if(value == 0){
							minCount++;
						}
						//最大差对数
						if(value == maxValue){
							maxCount++;
						}
					}
				}
			}
			
//			System.out.println("最小值："+minValue);
			if(minValue == 0)
				System.out.println(minCount/2);
			else {
				System.out.println(minCount);
			}
			
//			System.out.println("最大值:"+ maxValue);
			System.out.println(maxCount);
             */
		}
			
	}
}

/*思路：
 * 
   1.先排序
         特殊情况：如果排完序之后发现数组中所有数都相同，直接输出结果
             结果为：差最大个数 = 差最小个数 = （n * (n-1))/2;(两两组合)
    2.统计数组中每种数字的个数（这里用的map）
    3.计算差最小个数
        3.1.如果数组中没有重复数字，说明最小差不为0，最小差肯定是数组中相邻两个数的差
            因此，遍历一边数组，计算并统计最小差。
        3.2.如果数组中有重复数字，说明最小差是0，此时，遍历一边map，数字个数不为0的
            数字会产生最小差0，利用公式计算即可
    4.计算差最大个数
        只有一种情况，最大值与最小值的两两组合，即最大值个数 * 最小值个数
    算法复杂度：排序O(nlogn), 统计O(n)
 */
