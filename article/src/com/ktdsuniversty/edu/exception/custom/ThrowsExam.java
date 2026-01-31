package com.ktdsuniversty.edu.exception.custom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.ktdsuniversty.edu.market.consumer.Buyer;

public class ThrowsExam {
	
	/**
	 * createNewInstance("클래스명 호출")("com.ktdsuniversty.edu.market.consumer")이런식
	 * ==> 해당 클래스의 인스턴스반환 리플렉션!
	 * @param classPath
	 * @return
	 * */
	public static Object createNewInstance(String classPath) {
		Class clazz=null;
		try {
		clazz = Class.forName(classPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(classPath+"존재하지않는클레스입니다.");
		}
		if(clazz !=null) {
			Constructor constructor=null;
			try {
				constructor= clazz.getConstructor(String.class,int.class);
			} catch (Exception e) {
				System.out.println("생성자못찾음");
			}
			if(constructor !=null) {
			try {
				Object instence=	constructor.newInstance("dd",100);
				return instence;
			} catch (InstantiationException e) {
				System.out.println("생성실패");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("접근권한없음");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("파라미터잘못온듯");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.out.println("생성자실행할떄 에라가있어");
				e.printStackTrace();
			}
			}
		
		}
		return null;
	}
	
	public static void main(String[] args) {
		Buyer cust = (Buyer) createNewInstance("com.ktdsuniversty.edu.market.consumer.Buyer");
		System.out.println(cust.getMaxCartWeight());
	}
}
