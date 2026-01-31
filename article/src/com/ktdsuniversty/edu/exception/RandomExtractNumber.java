package com.ktdsuniversty.edu.exception;

public class RandomExtractNumber {

	private String[] numbers;

	public RandomExtractNumber() {
		this.numbers = new String[100];
		int index = 0;
		for (int i = 0; i < 10; i++) {
			// 0 ~ 99 하나.
			index = (int) (Math.random() * this.numbers.length);
			this.numbers[index] = (int) (Math.random() * 1_000_000) + "";
		}

		for (int i = 0; i < 10; i++) {
			// 0 ~ 99 하나.
			index = (int) (Math.random() * this.numbers.length);
			this.numbers[index] = (char) ((int) (Math.random() * 26) + 97) + "";
		}
	}

	public void printNumber(int index) {
		// this.numbers 의 index에 존재하는 값을 출력한다.
		// 값이 숫자인 경우 그대로 출력하고
		// 숫자가 아닌 경우 0을 출력한다.

		if (this.numbers.length > index) {
			if (this.numbers[index] == null) {
				System.out.println("0");
				numbers[index] = "";
			} else {
				if (this.numbers[index].matches("^[0-9]+$")) {
					System.out.println("값은 숫자임" + this.numbers[index]);
				} else {
					System.out.println("0");
				}
			}
		} else {
			System.out.println("0");
		}

//			RandomExtractNumber ren = new RandomExtractNumber();
//			int index2 = (int) (Math.random()*1000);
//			ren.printNumber(index2);

	}
	
	public void printNumber2(int index) {
		if(index >= 0&& index < this.numbers.length) {
			String value = this.numbers[index];
			if(value!=null && value.matches("^[0-9]+$")) {
				int intValue = Integer.parseInt(value);
				System.out.print(intValue);
				return;
			}
		}
	}

	public static void main(String[] args) {
		RandomExtractNumber ren = new RandomExtractNumber();
		int index = (int) (Math.random() * 200);
		for (int i = 0; i < 10; i++) {
			 index = (int) (Math.random() * 100);
			ren.printNumber(index);
			ren.printNumber2(index);
		}
	}
}
