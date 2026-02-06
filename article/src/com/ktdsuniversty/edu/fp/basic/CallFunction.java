package com.ktdsuniversty.edu.fp.basic;

import com.ktdsuniversty.edu.fp.basic.impl.CallAge;
import com.ktdsuniversty.edu.fp.basic.impl.CallAge2;
import com.ktdsuniversty.edu.fp.basic.impl.PrintName2;

public class CallFunction {

	public void callInterface(PrintSomething ps) {
		String something = "반갑습니다";
		ps.print(something);
	}
	
	public void callAbstractClass(CallSomething cs) {
		String somethins ="444";
		int result = cs.call(somethins);
		System.out.println(result);
	}

	public static void main(String[] args) {
		CallFunction cf = new CallFunction();
		cf.callInterface(new PrintName2());
		cf.callAbstractClass(new CallAge2());
		
		cf.callInterface(new PrintSomething() {

			@Override
			public void print(String message) {
				System.out.println(message);
				if(message !=null) {
					System.out.println(message+"는"+message.length()+"글자입니다");
				}
			}});
		cf.callAbstractClass(new CallSomething() {

			@Override
			public int call(String message) {
				if(message !=null) {
					return message.length();
				}
				return 0;
			}});
		
		
		//메소드만 전달.
		cf.callInterface((String message) -> {System.out.println("test"+message+ "입니다");});
		cf.callInterface((String message) -> System.out.println("test"+message+ "입니다"));
//		cf.callAbstractClass((String message) -> {return 0;});
		
		PrintSomething function = (String message) ->{
			if(message==null) {
				System.out.println("파라미터 잘못된거같아");
			}else {
				System.out.println(message.repeat(40));
			}
		};
		System.out.println(function);
		cf.callInterface(function);
		
	}
}
