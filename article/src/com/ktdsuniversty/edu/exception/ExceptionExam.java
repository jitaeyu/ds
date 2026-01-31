package com.ktdsuniversty.edu.exception;

public class ExceptionExam {
//모든 인스턴스에서 .을 사용할때 무조건 null체크를 해야하는가?
//		.을 사용하려는 인스턴스가 null이 될수있는가능성이 조금이라도 있다면 null체크를한다
	
	public static void nullExam(String str) {
		//str이 비어있지않으면 내용을 출력한다
		if(str!= null&&!str.isEmpty()) {
			System.out.println(str);
		}
	}
	public static void arrayIndexExam(String[] arr, int index) {
			if(arr !=null && index>=0 && index < arr.length) {
				System.out.println(arr[index]);
			}
		}
	public static void numberFormatExam(String str) {
		//11자리, 22억 ==> 0으로치환 잘못된값이다

		if(str==null) {

			System.out.println(0);
			return;
		}
		str=str.replace("_", "");
		
		if(str.length()>10) {
			System.out.println("범위를 벗어났습니다.");
		}
		if(str.matches("^[0-9]+${1,10}")) {
			long tempNum = Long.parseLong(str);
			if(tempNum>Integer.MAX_VALUE) {
				tempNum=0;
			}
			int num =(int) tempNum;
			System.out.println(num);
			
		}else {
			System.out.println(0);
		}
		
		
		
	}
	public static void main(String[] args) {
//		nullExam("1232");
//		nullExam("      ");
//		
//		nullExam("");
//
//		nullExam("112421412421232");
//
//		nullExam(null);
		
//		arrayIndexExam(new String[] {"a","b"},0);
//		arrayIndexExam(new String[] {"a","b"},1);
//		arrayIndexExam(new String[] {"a","b"},2);
//		arrayIndexExam(new String[] {"a","b"},-1);
//		arrayIndexExam(null,-1);
//		arrayIndexExam(null,0);
		numberFormatExam("10");
		numberFormatExam("2000");
		numberFormatExam("300_000_000");
//		numberFormatExam("3000000000");
//		numberFormatExam("1.213213");
		numberFormatExam(null);
	}
}
