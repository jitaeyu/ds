package impl;

import fp.CallSomething;

public class CallAge2 extends CallSomething{

	@Override
	public int call(String message) {
		try {
			return Integer.parseInt(message);
					
		} catch (NumberFormatException nfe) {
		}
		return 0;
	}
}
