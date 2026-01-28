package com.ktdsuniversty.edu.inheritance;

public class Animal {

	private String name;
	private String voice;
	
	private float speed;
	private float damage;
	private float hp;
	
	public Animal(String name, String voice,float speed,float damage,float hp) {
		this.name=name;
		this.voice=voice;
		this.speed=speed;
		this.damage=damage;
		this.hp=hp;
		
	}
	
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void howling() {
		System.out.println(this.name+" : "+this.voice);
	}
	
	public void move() {
		System.out.println(this.name+":"+this.speed+"KM/H의 속도로 움직임");
		
	}
	public void attack(Animal other) {
		if(this.isDead()) {
			System.out.println(this.name+"이 죽어서 행동할수없습니다");
		}
		if(!(this instanceof Bird)&& other instanceof Bird bird) {
//			bird가 날고있으면 공격불가
			if(bird.getIsFly()) {
				System.out.println(other.getName()+"날고있어 떄릴수없습니다");
				return;
			}
		}
		
		System.out.println(this.name+"이"+other.getName()+"에게 공격하려합니다");
		if(!other.isDead()){
			other.getDamage(this.damage);
		}else {
			System.out.println(other.getName()+"이 상처받았습니다");
		}
	}
	public void getDamage(float damage) {//getter 아님
		System.out.println(this.name+"이"+damage+"만큼 상처받았습니다");
		this.hp-=damage;
	}
	
	public boolean isDead() {
		return this.hp<=0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if (obj instanceof Animal other) {
			return other.getName().equals(this.name);
		}
		return super.equals(obj);
	}


	@Override
	public String toString() {
		return "Animal [name=" + name + ", voice=" + voice + ", speed=" + speed + ", damage=" + damage + ", hp=" + hp
				+ "]";
	}
	
	
	
	
	
}
