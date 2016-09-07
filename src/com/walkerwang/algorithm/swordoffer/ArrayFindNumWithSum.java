package com.walkerwang.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayFindNumWithSum {
	public static void main(String[] args) {
		//arrayΪ��������
		int[] array ={1,2,4,7,11,16};
		int sum = 11;
		new ArrayFindNumWithSum().FindNumbersWithSum(array, sum);
	}
	
	/**
	 * ����ʱ�䣺34ms
		ռ���ڴ棺528k
	 */
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if (array.length <=1) {
			return list;
		}
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int i=0;
		int j=array.length-1;
		while(i < j){
			if(array[i] + array[j] == sum){
				list.add(array[i]);
				list.add(array[j]);
				//�������ֱ����list���������list.clear()�����map�е�ֵlist����һ�㲻����
				//�ѽ����ʹ�ù��췽��new ArrayList<>(list)Ϊlist���·���һ���ڴ�
				//map.put(array[i]*array[j], (ArrayList<Integer>) list.clone());
				map.put(array[i]*array[j], new ArrayList<>(list));
//				System.out.println(map.get(array[i]*array[j]));
				list.clear();
//				System.out.println(map.get(array[i]*array[j]));
				j--;
			}if(array[i] + array[j] < sum){
				i++;
			}else{
				j--;
			}
		}
		Set<Map.Entry<Integer, ArrayList<Integer>>> set = map.entrySet();
		if(set.size() == 0){
			return list;
		}
		Iterator<Map.Entry<Integer, ArrayList<Integer>>> iter = set.iterator();
		int minKey = Integer.MAX_VALUE;
		while(iter.hasNext()){
			Map.Entry<Integer, ArrayList<Integer>> entry = iter.next();
			if (entry.getKey() < minKey) {
				minKey = entry.getKey();
			}
		}
		System.out.println(minKey);
		list = map.get(minKey);
		System.out.println(list.get(0)+ " " + list.get(1));
		return list;
	}
}
