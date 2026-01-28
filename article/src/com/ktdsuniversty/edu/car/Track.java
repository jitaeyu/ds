package com.ktdsuniversty.edu.car;

public class Track {
	
	public static void main(String[] args) {
		Vehicle car = new Vehicle("차차차");
		Vehicle car2 = new SportsCar("고급차");
		
		car.startEngine();
		car2.startEngine();
	}

}
