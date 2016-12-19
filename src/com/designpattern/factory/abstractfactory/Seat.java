package com.designpattern.factory.abstractfactory;

public interface Seat {
	void massage();
}

class LuxurySeat implements Seat {

	@Override
	public void massage() {
		System.out.println("高端轮椅");
	}
}

class LowSeat implements Seat {
	@Override
	public void massage() {
		System.out.println("低端轮椅");
	}
}
