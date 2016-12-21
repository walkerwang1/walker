package com.designpattern.builder;

public class client {

	public static void main(String[] args) {
		//多态。Map map = new HashMap();   List list = new ArrayList();
		//接口对象 = new 实现类()
		AirShipDirector director = new AudiAirShipDirector(new AudiAirShipBuilder());
		
		AirShip ship = director.directAirShip();
		
		System.out.println(ship.getEngine().getName());
	}
}
