package com.ktdsuniversty.edu.fp.basic.impl;

import com.ktdsuniversty.edu.fp.basic.CallSomething;

public class CallAge extends CallSomething{

	@Override
	public int call(String message) {
		return Integer.parseInt(message);
	}
}
