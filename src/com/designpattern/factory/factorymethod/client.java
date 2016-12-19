package com.designpattern.factory.factorymethod;

public class client {

	public static void main(String[] args) {
		Car audi = new AudiFactory().createCar();
		Car bmw = new BmwFactory().createCar();
		
		audi.run();
		bmw.run();
	}
}
