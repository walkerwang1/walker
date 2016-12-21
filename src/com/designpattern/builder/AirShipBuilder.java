package com.designpattern.builder;

/**
 * 构建者
 * @author walkerwang
 *
 */
public interface AirShipBuilder {
	/**
	 * 构建发动机
	 * @return
	 */
	Engine builderEngine();
	
	/**
	 * 构建轨道舱
	 * @return
	 */
	OrbitalModule builderOrbitalModule();
	
	/**
	 * 构建逃逸塔
	 * @return
	 */
	EscapeTower builderEscapeTower();
}
