package com.designpattern.builder;


public class AirShip {
	private Engine engine; 	//发动机
	private OrbitalModule orbitalModule; 	//轨道舱
	private EscapeTower escapeTower;	//逃逸塔
	
	public void launch() {
		System.out.println("发射");
	}
	
	public OrbitalModule getOrbitalModule() {
		return orbitalModule;
	}
	public void setOrbitalModule(OrbitalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public EscapeTower getEscapeTower() {
		return escapeTower;
	}
	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}
}

/**
 * 发动机
 * @author walkerwang
 *
 */
class Engine {
	private String name;
	
	public Engine(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

/**
 * 轨道舱
 * @author walkerwang
 *
 */
class OrbitalModule {
	private String name;
	
	public OrbitalModule(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

/**
 * 逃逸塔
 * @author walkerwang
 *
 */
class EscapeTower {
	private String name;
	
	public EscapeTower(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
