package com.designpattern.prototype;

import java.util.Date;

/**
 * 原型模式（浅拷贝/浅复制）
 * @author walkerwang
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Date date = new Date(11122142L);
		Sheep s1 = new Sheep("多利", date);
		Sheep s2 = (Sheep)s1.clone();

		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		date.setTime(23135313513515L);
		System.out.println(s1.getBirthday());
		
		s2.setSname("少利");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
	}
}
