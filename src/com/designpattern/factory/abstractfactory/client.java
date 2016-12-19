package com.designpattern.factory.abstractfactory;

public class client {

	public static void main(String[] args) {
		CarFactory factory = new LuxuryCarFactory();
		Engine engine = factory.createEngine();
		engine.start();
	}
}
