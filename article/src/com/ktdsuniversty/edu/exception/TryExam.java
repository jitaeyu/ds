package com.ktdsuniversty.edu.exception;

public class TryExam {

	public static void handleException() {
		try {
			Class.forName("com.ktdsuniversty.edu.exception.TryExam");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void numberFormatExam(String str) {
		
		if (str != null) {
			int value = 0;
			try {
				System.out.println("변환전");
				value = Integer.parseInt(str);
				System.out.println("변환후");

			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
				nfe.printStackTrace();// 애러가 발생하게된 원인들을 모두출력(call stack모두출력)
			}
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		numberFormatExam("100000");
		numberFormatExam("12331232133312321421421421");
		
		handleException();
	}
}
