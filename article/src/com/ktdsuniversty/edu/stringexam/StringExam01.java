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
		String bj = "abcdefghijklmnopqrxyz";
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
	}
	
	public static void main(String[] args) {
//		StringExam01 exam = new StringExam01();
		StringExam01 exam = new StringExam01();
		exam.Exam01();
		exam.Exam02();
		exam.Exam03();
		exam.Exam04();
		exam.Exam05();
	}
}
