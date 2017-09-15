package com;

import java.util.Scanner;

public class Ali01 {
	private static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;

	//箱子，所有商品
	private static int process(BoxTemplate boxTemplate, Model[] items) {
		int boxMinNum = 0;
		
		int maxprice = boxTemplate.price;
		int count = items.length;
		while(count > 0) {
			boxMinNum++;
			
			for(int i = 0; i < items.length; i++) {
				
				for(int w = 1; w <= maxprice; w++){
					if (items[i].price != 0 && items[i].price <= w) { 	//价格小于w时
						if (items[i].length < boxTemplate.length && items[i].width < boxTemplate.width &&
								items[i].height < boxTemplate.height) {
							items[i].clear();
							count--;
						}
					} else {
						
					}
				}
			}
		}
		return boxMinNum;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		BoxTemplate boxTemplate = new BoxTemplate();
		boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

		while (scanner.hasNext()) {
			boxTemplate.length = scanner.nextInt();		//箱子的长宽高
			boxTemplate.width = scanner.nextInt();
			boxTemplate.height = scanner.nextInt();

			int itemNum = scanner.nextInt();	//商品数量
			Model[] items = new Model[itemNum];
			for (int i = 0; i < itemNum; i++) {
				Model item = new Model();
				item.price = scanner.nextInt();
				item.length = scanner.nextInt();
				item.width = scanner.nextInt();
				item.height = scanner.nextInt();
				items[i] = item;
			}
			long startTime = System.currentTimeMillis();
			int boxMinNum = Integer.MAX_VALUE;
			boxMinNum = process(boxTemplate, items);
			System.out.println(boxMinNum);

		}
	}
	static class Model {
		public Model() {
			// TODO Auto-generated constructor stub
		}
		int price;
		int length;
		int width;
		int height;
		
		void clear() {
			price = 0;
		}
	}
	
	static class BoxTemplate {
		public BoxTemplate() {
			
		}
		int price;
		
		int length;
		int width;
		int height;
	}
}

