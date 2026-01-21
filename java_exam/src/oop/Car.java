package oop;

/**
 * <pre>
 * 엔진의 시동여부
 * 엔진이 꺼져있을때는 가속페달을 누르거나 브레이크페달을 밟아도 아무런효과가 없다
 * 엔진이 켜져있을때는 누르는페달에 따라 속도(speed)가 변화한다.
 * </pre>
 * */
public class Car {
	boolean isEngineStart;
	
	/**
	 * 자동차의현재속도표시
	 * 가속패달을 누르면 속도증가
	 * 브레이크페달 누르면 속도감소*/
	int speed;
	
	/**
	 * <pre>
	 * 엔진 상태에 따라서 시동을 켜거나 끈다
	 * 시동이 걸리면 isEngineStart의 값이 true,꺼지면 false가된다
	 * 시동이 꺼지면 speed의 값은 0이다
	 * 시동이 켜지면 speed의 값은 10이 된다<pre>*/
	public void pressEngineStartButton() {
		if(isEngineStart) {
			isEngineStart = false;
			speed=0;
			System.out.println("시동 OFF");
			System.out.println("현재 속도는 "+speed);
		}else {
			isEngineStart = true;
			speed=10;
			System.out.println("시동 ON");
			System.out.println("현재 속도는 "+speed);
		}
	}
	/**<pre>
	 *  시동이 켜져있을때 가속페달을 누르는만큼 입력속도가증가
	 * </pre>
	 * @param press 가속페달을 누르는 입력의 강도
	 * */
	public void pressGasolinPedal(int press) {
		if(isEngineStart) {
			speed+=press;
			System.out.println("현재 속도는 "+speed);
		}
	}
	/**<pre>
	 *  시동이 켜져있을때 가속페달을 누르는만큼 입력속도감소
	 * </pre>
	 * @param press 브레이크페달을 누르는 입력의 강도
	 * */
	public void pressBreakPedal(int press) {
		if(isEngineStart) {
			speed -=press;
			if(speed<0) {
				speed=0;
			}
			System.out.println("Now Speed "+ speed);
		}
		
	}
	
}
