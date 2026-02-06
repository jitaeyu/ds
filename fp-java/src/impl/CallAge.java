package impl;

import fp.CallSomething;

public class CallAge extends CallSomething{

	@Override
	public int call(String message) {
		return Integer.parseInt(message);
	}
}
