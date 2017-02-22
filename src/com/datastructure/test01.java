package com.datastructure;

public class test01 {
	public test01() {
		// TODO Auto-generated constructor stub
	}
	
	public int test01(){
		return 0;
	}
	
	public static void main(String[] args) {
		 Thread t = new Thread() {
	            public void run() {
	                pong();
	            }
	        };
	        t.start();
	        System.out.print("ping");
	    }
	    static void pong() {
	        System.out.print("pong");
	}
}
