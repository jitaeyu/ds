package com.ktdsuniversty.edu.exception;

import com.ktdsuniversty.edu.exception.custom.DevideZeroException;
import com.ktdsuniversty.edu.exception.custom.NullOperatorException;
import com.ktdsuniversty.edu.exception.custom.WrongOperatorException;

public class SimPleCalculator {

	/**
	 * 계산기
	 * 
	 * @param a계산할값
	 * @param b           계산할값
	 * @param operator연산자 (+, -, *,/)
	 * @return 연산자에 따른 결과를 반환
	 */
	public int calc(int a, int b, String operator) {
		int result = 0;

		if (operator == null) {
//			System.out.println("잘못된 연산자입니다");
//			throw new NumberFormatException("잘못된 연산자입니다");
		} else if (operator.equals("+")) {
			result = a + b;
			System.out.println(result);
		} else if (operator.equals("-")) {
			result = a - b;
			System.out.println(result);
		} else if (operator.equals("*")) {
			result = a * b;
			System.out.println(result);
		} else if (operator.equals("/")) {
			if (a == 0 || b == 0) {
//				throw new DevideZeroException("잘못된숫자");
//				System.out.println("잘못된숫자");
//				return 0;
			}

			result = a / b;
			System.out.println(result);
		} else {
//			throw new WrongThreadException("다른 연산자를 입력해주세요");
//			System.out.println("다른 연산자를 입력해주세요");
		}
		return 0;
	}

	public static void main(String[] args) {
		SimPleCalculator sc = new SimPleCalculator();

		int result = 0;
		try {
			result = sc.calc(10, 10, "%");
		} catch (NullOperatorException re) {// 연산자가 null
			System.out.println("연산자 null");
		} catch (DevideZeroException d) {
			System.out.println("0으로 나누려했다니 가소롭군");
			// TODO: handle exception
		} catch (WrongOperatorException r) {
			System.out.println("G1하지않는연산자입니다 다시실행하세요");
		}
		System.out.println("1끝");
		try {
			result = sc.calc(10, 10, null);
		} catch (NullOperatorException re) {// 연산자가 null
			System.out.println("연산자 null");
		} catch (DevideZeroException d) {
			System.out.println("0으로 나누려했다니 가소롭군");
			// TODO: handle exception
		} catch (WrongOperatorException r) {
			System.out.println("G1하지않는연산자입니다 다시실행하세요");
		}
		System.out.println("2끝");
		try {
			result = sc.calc(0, 0, "%");
		} catch (NullOperatorException re) {// 연산자가 null
			System.out.println("연산자 null");
		} catch (DevideZeroException d) {
			System.out.println("0으로 나누려했다니 가소롭군");
			// TODO: handle exception
		} catch (WrongOperatorException r) {
			System.out.println("G1하지않는연산자입니다 다시실행하세요");
		}

		try {
			result = sc.calc(10, 10, null);
		}catch (NullOperatorException re) {// 연산자가 null
			System.out.println("연산자 null");
		} catch (DevideZeroException d) {
			System.out.println("0으로 나누려했다니 가소롭군");
			// TODO: handle exception
		} catch (WrongOperatorException r) {
			System.out.println("G1하지않는연산자입니다 다시실행하세요");
		}
	}
}
