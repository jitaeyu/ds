package com.ktdsuniversty.edu.car;

public class SportsCar extends Vehicle{
	public boolean enabledTurbo;

	public SportsCar(String modelName,String enginesound) {
		super(modelName,enginesound);
	}

	@Override
	public void startEngine() {
		super.startEngine();
		System.out.println("boom!");
	}
	public SportsCar(String modelName) {
		super(modelName);;
	}
	
	public void startTurbo() {
		if (super.getIsStart()) {
			this.enabledTurbo = !this.enabledTurbo;

			String modelName = super.getModelName();
			if (this.enabledTurbo) {
				System.out.println(modelName + " 터보 시작됐습니다.");
			} else {
				System.out.println(modelName + " 터보 종료됐습니다.");
			}
		}
	}
}
