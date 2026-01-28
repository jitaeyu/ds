package com.ktdsuniversty.edu.car;

public class BatMobile extends SportsCar{

	private boolean isDetachBatPod;

	public BatMobile(String modelName) {
		super(modelName);
	}

	public void detachBatPod() {
		if (super.getIsStart()) {
			this.isDetachBatPod = !this.isDetachBatPod;

			String modelName = super.getModelName();
			if (this.isDetachBatPod) {
				System.out.println(modelName + " 배트포드 분리됐습니다.");
			} else {
				System.out.println(modelName + " 배트포드 결합됐습니다.");
			}
		}
	}
}
