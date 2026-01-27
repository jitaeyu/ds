package com.ktdsuniversty.edu.stringexam;

import java.awt.Font;

public class StringExam01 {

//	private Scanner keyboard;
	
	public StringExam01() {
//		this.keyboard = new Scanner(System.in);
	}
	
	public void Exam01() {
	
		String exam01 = "sprout";
//		String b=exam01.substring(1, 3);
		String exam1= exam01.charAt(3-1)+"";
		System.out.println("Q1: "+exam1);
	}
	
	public void Exam02() {
		String exam02="pulljima";
		int answer = exam02.length();
		System.out.println("Q2: "+answer);
	}

	public void Exam03() {
		String exam03="A";
		int answer = exam03.charAt(0);
		System.out.println("Q3: "+answer);
	}
	
	public void Exam04() {
		String data02 = "54321";
		int sum = 0;
		for (int i = 0; i < data02.length() ; i++) {
			 String a = data02.charAt(i)+"";
			sum+=Integer.parseInt(a);
		}
		System.out.println("Q4: "+sum);
	}
	
	public void Exam05() {
		String az = "baekjoon";
		String bj = "abcdefghijklmnopqrstuvwxyz";
//		String az="baekjoon";
		System.out.print("Q5: ");
		for(int i=0;i<bj.length();i++) {
			String fornt = bj.charAt(i)+"";
			for (int j = 0; j < az.length(); j++) {
				String end =az.charAt(j)+"";
				if(fornt.equals(end)) {
					System.out.print(j+" ");
					continue;
				}else if(j==az.length()-1){
					System.out.print("-1 ");
					
				}
			}
		}
		System.out.println();
	}
	
	public void Exam06() {
		String bj = "The Curious Case of Benjamin Button";
		int count= 0;
		for (int i = 0; i < bj.length(); i++) {
			if (bj .charAt(i) == ' ') {
				count++;
			}
		}
		System.out.println("Q6 : "+(count+ 1));
	}
	
	public void Exam07() {
		String su= "734 893";
		String[] number = su.split(" ");
		String a = number[0];
		String sangsu= "" + a.charAt(2) + a.charAt(1) + a.charAt(0);
		String b = number[1];
		String stupitSangsu = "" + b.charAt(2) + b.charAt(1) + b.charAt(0);
		int numberA = Integer.parseInt(sangsu);
		int numnerB = Integer.parseInt(stupitSangsu);
		if(numberA>numnerB){
			System.out.println("Q7: "+numberA);
		}else{
				System.out.println("Q7: "+numnerB);
		}
	}
	
	public void ExamPg01() {
		String a = "abc";
		String b = "aabcc";
			if (b.contains(a)) {
				System.out.println("Q1: "+1);
			} else {
				System.out.println("Q1: "+0);
			}
	}
	public void ExamPg02() {
		String a = "banana";
		String b = "ana";
		if (a.contains(b)) {
			System.out.println("Q2 : "+1);
		} else {
			System.out.println("Q2 : "+0);
		}
	}
	
	public void ExamPg03() {
		 int number = 123;
		 String dap = String.valueOf(number);
		 System.out.println("Q3: "+dap);
	}
	public void ExamPg04() {
		String number = "10";
		int dap = Integer.parseInt(number);
		System.out.println("Q4: "+dap);
	}
	public void ExamPg05() {
		String number = "0010";
		int dapInt = Integer.parseInt(number);
		String dapString = String.valueOf(dapInt);
		System.out.println("Q5: "+dapString);
	}
	public void ExamPg06() {
		String number = "123456789";
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += number.charAt(i) - '0';
		}
		System.out.println("Q6: "+sum);
	}
	public void ExamPg07() {
		String a = "aBcDeFg";
		String dap = a.toLowerCase();
		System.out.println("Q7: "+dap);
}
	public void ExamPg08() {
		String a= "AbCdEfG";
		String b = "aBc";
		int dap=0;
		if (a.toLowerCase().contains(b.toLowerCase())) {
			dap= 1;
		} else {
			dap= 0;
		}
	System.out.println("Q8: "+dap);
	}

	public void ExamPg09() {
		String[] strArr = {"AAA", "BBB", "CCC", "DDD"};
		for (int i = 0; i < strArr.length; i++) {
			if (i % 2 == 0) {
				strArr[i] = strArr[i].toLowerCase();
			} else {
				strArr[i] = strArr[i].toUpperCase();
			}
		}		
		System.out.print("Q9: ");
		for (String s : strArr) {
			System.out.print(s + " ");
	}
}
	
	public static void main(String[] args) {
		StringExam01 exam = new StringExam01();
		exam.Exam01();
		exam.Exam02();
		exam.Exam03();
		exam.Exam04();
		exam.Exam05();
		exam.Exam06();
		exam.Exam07();
		exam.ExamPg01();
		exam.ExamPg02();
		exam.ExamPg03();
		exam.ExamPg04();
		exam.ExamPg05();
		exam.ExamPg06();
		exam.ExamPg07();
		exam.ExamPg08();
		exam.ExamPg09();
		System.out.println();
		String aaaa="	";		System.out.println("1"+aaaa+"1");
	}
}
