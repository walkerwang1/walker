package com.designpattern.factory.simplefactory;

public class SimpleFactory {

	public static Car createCar(String type) {
		Car c = null;
		switch (type) {
		case "奥迪":
			c = new Audi();
			break;
		case "宝马":
			c = new Bmw();
			break;
		default:
			break;
		}
		return c;
	}
}
