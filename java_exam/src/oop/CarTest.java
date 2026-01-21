package oop;

public class CarTest {
	
	public static void main(String[] args) {
		int[] scoreArray = new int[7];
		Car kona = new Car();
		Car kanibal = new Car();
		System.out.println(kona);
		boolean konaEnginState = kona.isEngineStart;
		
		kona.pressEngineStartButton();
		kona.pressGasolinPedal(20);
		
		kanibal.pressGasolinPedal(200);
		kanibal.pressEngineStartButton();
		kanibal.pressBreakPedal(20);
		System.out.println("Engine state: "+konaEnginState);
//		코나 엔진상태출력
//		코나 현재 속도를 출력
		
		
		
		System.out.println(kanibal);
	}

}
