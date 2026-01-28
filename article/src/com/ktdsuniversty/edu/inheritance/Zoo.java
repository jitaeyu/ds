package com.ktdsuniversty.edu.inheritance;

public class Zoo {

	public static void main(String[] args) {
		Animal duck = new Bird("오리","꽥",15, 20, 50f);
		Animal duck2 = new Bird("오리","꽥",15, 20, 50f);
		System.out.println("== :"+(duck==duck2));
		System.out.println("equals :"+duck.equals(duck2));
		
		
		duck.howling();
		duck.move();
//		duck.notify();
		if(duck instanceof Bird) {
			Bird bird = (Bird)duck;
			bird.fly();
			bird.land();

		}
		if(duck instanceof Bird bird) {
			bird.fly();
			
			
		}
		
//		duck.l
		Animal lion = new Animal("사자","크아앙",30f,60,200f);
		Animal tiger = new Animal("호랑이","어흥",50f, 55f,200f);
		
		duck.attack(tiger);
		
		tiger.attack(duck);
		
		StringBuffer sb =new StringBuffer();
		sb.append("asdasdads");
		duck.toString();
		
//		
//		lion.howling();
//		tiger.howling();
//		
//		lion.move();
//		tiger.move();
//		
//		lion.attack(tiger);
//		lion.attack(tiger);
//		lion.attack(tiger);
//		lion.attack(tiger);
//		lion.attack(tiger);
//		lion.attack(tiger);
//		lion.attack(tiger);
//		tiger.attack(lion);
	}
}
