package com.walkerwang.demo;

import java.io.Serializable;
import java.util.Arrays;

public class test_private implements Serializable{

	
	 transient int[] element;
	
	 class nestClass {
	
		void get() {
			element = new int[10];
		}
	}
	 
	 public static void main(String[] args) {
	}
}
