package com.ktdsuniversty.edu.car;

public class EV extends Vehicle{

	private int batteryAmount;

	public EV(String modelName, String engineSound,int batteryAmount) {
		super(modelName,engineSound);
		this.batteryAmount = batteryAmount;
	}
	
	@Override
	public void startEngine() {
		super.startEngine();
		System.out.println("위이잉");
	}

	public void printBatteryAmount() {
		if (super.getIsStart()) {
			String modelName = super.getModelName();
			System.out.println(modelName + " 배터리 잔량은 " + this.batteryAmount + "입니다.");
		}
	}
}
