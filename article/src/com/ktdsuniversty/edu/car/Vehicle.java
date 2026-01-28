package com.ktdsuniversty.edu.car;

public class Vehicle {
	private String modelName;
	private boolean isStart;
	private String engineSound;
	
	public Vehicle(String modelName) {
		this.modelName=modelName;
		this.engineSound="브르르릉";
	}
	
	public Vehicle(String modelName,String engineSound) {
		this.modelName = modelName;
		this.engineSound=engineSound;
	}
	
	public String getModelName() {
		return this.modelName;
	}
	
	public boolean getIsStart() {
		return this.isStart;
	}
	
	public void startEngine() {
		this.isStart = !isStart;
		if (this.isStart) {
			System.out.println(this.modelName + this.engineSound);
		}
		else {
			System.out.println(this.modelName + this.engineSound);
		}
	}
	
	
}
