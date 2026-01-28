package com.ktdsuniversty.edu.inheritance;

public class Bird extends Animal{

	private boolean isFly;
	private float walkingSpeed;
	public Bird(String name, String voice, float speed, float damage, float hp) {
		super(name, voice, speed, damage, hp);
		this.walkingSpeed = speed;
	}
	
	public boolean getIsFly() {
		return this.isFly;
	}

	public void fly() {
		this.isFly=true;
		super.setSpeed(70);
	}
	public void land() {
		this.isFly =false;
		super.setSpeed(this.walkingSpeed);
	}
	
	//bird 클래스 최종 SuperClass인 toString()메소드를 다시 정의한다
	@Override
	public String toString() {
		String str = "Bird [name: %s, isFly: %s]";
		return str.formatted(super.getName(),this.isFly);
	}
	
}
