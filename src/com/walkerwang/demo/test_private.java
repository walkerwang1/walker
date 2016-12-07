package com.walkerwang.demo;

import java.io.Serializable;

public class test_private implements Serializable{

	
	 transient int[] element;
	
	 class nestClass {
	
		void get() {
			element = new int[10];
		}
	}
}
