package com.designpattern.factory.abstractfactory;

public interface Tyre {
	void revolve();
}

class LuxuryTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("高端轮胎");
	}
}

class LowTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("低端轮胎");
	}
}

