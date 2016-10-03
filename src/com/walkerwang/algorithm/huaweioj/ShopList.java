package com.walkerwang.algorithm.huaweioj;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopList {
	public static void main(String[] args) {
		// 1000 5 800 2 0 400 5 1 300 5 1 400 3 0 500 2 0
		ArrayList<Goods> list = new ArrayList<>();
		list.add(new Goods(0, 0, 0));
		Scanner scanner = new Scanner(System.in);
		int total = scanner.nextInt();
		int number = scanner.nextInt();
		for(int i=1; i<=number; i++){
			int price = scanner.nextInt();
			int weight = scanner.nextInt();
			int isAnnex = scanner.nextInt();
			Goods goods = new Goods(price, weight, isAnnex);
			list.add(goods);
		}
		System.out.println(list.size());
		/*
1000
5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0

1000
5
400 5 1
800 2 0
500 2 0
400 3 0
300 5 1

		 */
//		int total = 1000;
//		int number = 5;
//		Goods g1 = new Goods(800, 2, 0);
//		Goods g2 = new Goods(400, 5, 1);
//		Goods g3 = new Goods(300, 5, 1);
//		Goods g4 = new Goods(400, 3, 0);
//		Goods g5 = new Goods(500, 2, 0);
//		ArrayList<Goods> list = new ArrayList<>();
//		list.add(g1);
//		list.add(g2);
//		list.add(g3);
//		list.add(g4);
//		list.add(g5);
		System.out.println(shop(list, total, number));
	}

	public static int shop(ArrayList<Goods> list, int total, int number) {
		int c[][] = new int[number + 1][total + 1];
		//备忘录法，自底向上
		for (int i = 0; i <= total; i++)
			c[0][i] = 0;
		for (int i = 0; i <= number; i++)
			c[i][0] = 0;

		for (int w = 1; w <= total; w++) {
			for (int i = 1; i <= number; i++) {
				Goods goods = list.get(i);
				//如果是附件
				if(goods.isAnnex > 0) {
					//如果  总额>附件价格+对应的主件价格
					if(w > goods.price + list.get(goods.isAnnex).price) {
						int value = c[i-1][w-goods.price] + goods.price*goods.weight;
						c[i][w] = value > c[i-1][w] ? value : c[i-1][w];
					}
				}else {	//主件（0-1背包问题）
					if(goods.price <= w) {
						int value = c[i-1][w-goods.price] + goods.price*goods.weight;
						c[i][w] = value > c[i-1][w] ? value : c[i-1][w];
					}
				}
			}
		}
		
		return c[number][total];
	}
}

class Goods {
	int price;
	int weight;
	int isAnnex;

	public Goods(int price, int weight, int isAnnex) {
		this.price = price;
		this.weight = weight;
		this.isAnnex = isAnnex;
	}
}