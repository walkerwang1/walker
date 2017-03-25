package com.walkerwang.algorithm.bigcompany;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuaWei02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String op = in.nextLine();
			if (op.length() > 50) {
				return;
			}

			// RA 436512
			Map<Character, Integer> map = new HashMap<>();
			map.put('L', 1);
			map.put('R', 2);
			map.put('F', 3);
			map.put('B', 4);
			map.put('O', 5);
			map.put('D', 6);
			char[] opChs = op.toCharArray();
			int tmp = 0;
			for (int i = 0; i < opChs.length; i++) {
				char ch = opChs[i];
				switch (ch) {
				// 向左翻转
				case 'L':
					tmp = map.get('O');
					map.put('O', map.get('R'));
					map.put('R', map.get('D'));
					map.put('D', map.get('L'));
					map.put('L', tmp);
					break;
				// 向右翻转
				case 'R':
					tmp = map.get('O');
					map.put('O', map.get('L'));
					map.put('L', map.get('D'));
					map.put('D', map.get('R'));
					map.put('R', tmp);
					break;
				// 向前翻转
				case 'F':
					tmp = map.get('O');
					map.put('O', map.get('B'));
					map.put('B', map.get('D'));
					map.put('D', map.get('F'));
					map.put('F', tmp);
					break;
				// 向后翻转
				case 'B':
					tmp = map.get('O');
					map.put('O', map.get('F'));
					map.put('F', map.get('D'));
					map.put('D', map.get('B'));
					map.put('B', tmp);
					break;
				// 逆时针
				case 'A':
					tmp = map.get('L');
					map.put('L', map.get('B'));
					map.put('B', map.get('R'));
					map.put('R', map.get('F'));
					map.put('F', tmp);
					break;
				// 顺时针
				case 'C':
					tmp = map.get('L');
					map.put('L', map.get('F'));
					map.put('F', map.get('R'));
					map.put('R', map.get('B'));
					map.put('B', tmp);
					break;
				default:
					break;
				}
			}
			printMap(map);
		}
	}

	public static void printMap(Map<Character, Integer> map) {
		System.out.print(map.get('L') + "" + map.get('R') + map.get('F') + map.get('B') + map.get('O') + map.get('D'));
	}
}
