package com.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Client2 {

	public static void main(String[] args) throws Exception {
		Date date = new Date(11122142L);
		Sheep s1 = new Sheep("多利", date);

		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		
		//使用序列化和反序列化实现深拷贝
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream    oos = new ObjectOutputStream(bos);
		oos.writeObject(s1);
		byte[] bytes = bos.toByteArray();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream	 ois = new ObjectInputStream(bis);
		Sheep s2 = (Sheep)ois.readObject();		//复制出一个“新Sheep”
		
		date.setTime(23135313513515L);
		System.out.println("modify:" + s1.getBirthday());
		
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
		
	}
}
