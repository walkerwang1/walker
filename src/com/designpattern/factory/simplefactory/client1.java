package com.designpattern.factory.simplefactory;

public class client1 {

	public static void main(String[] args) {
		Car audi = SimpleFactory.createCar("奥迪");
		Car bmw = SimpleFactory.createCar("宝马");
		
		audi.run();
		bmw.run();
	}
}
