package com.ktdsuniversty.edu.string;

public class StringConcat {
	
	
	public static void main(String[] args) {
		String abcd = "fjdingskgmpdsfgsd";
		int a = 0;
		
//		for(int i = 0; i<100;i++) {
//			abcd += abcd;
//			System.out.println(i);
//		}
		int i=0;
		while(true) {
			abcd += abcd;
			if(i>100) {
				break;
				
			}
		}
	}
	

}
