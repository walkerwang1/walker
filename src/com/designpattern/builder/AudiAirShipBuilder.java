package com.designpattern.builder;

/**
 * 
 * @author walkerwang
 *
 * StringBuilder,以后学习XML解析中，JDOM库中的类：DomBuilder、SaxBuilder
 */
public class AudiAirShipBuilder implements AirShipBuilder{

	@Override
	public Engine builderEngine() {
		System.out.println("构建Audi发动机");
		//可以通过工厂模式构建一个对象
		return new Engine("Audi发动机");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("构建Audi轨道舱");
		return new OrbitalModule("Audi轨道舱");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		System.out.println("构建Audi逃逸塔");
		return new EscapeTower("Audi逃逸塔");
	}

}
