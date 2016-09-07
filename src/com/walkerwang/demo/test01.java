package com.walkerwang.demo;


import java.util.Date; 
public class test01 extends Date{ 
    private static final long serialVersionUID = 1L; 
    private void test(){ 
       System.out.println(super.getClass().getName()); 
    } 
      
    public static void main(String[]args){ 
       new test01().test(); 
    } 
}
