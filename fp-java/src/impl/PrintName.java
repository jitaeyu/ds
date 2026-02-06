package impl;

import fp.PrintSomething;

public class PrintName implements PrintSomething{
	@Override
	public void print(String message) {
		System.out.println(message.repeat(5));
	}
	
}
