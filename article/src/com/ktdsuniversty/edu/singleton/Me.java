package com.ktdsuniversty.edu.singleton;

public class Me {

	//전역 => static
	private static Me me;
	private String name;
	
	private Me() {
		//생성자는 공개하지않는다 아무데서나 인스턴스화를 방지하기위해
		this.name="jitae";
	
	}
	//싱글톤 패턴이다.
	// 스태틱이기떄문에 한번 생성된 인스턴스는 (종료시까지)절대 바뀌지않는다
	public static Me getInstance() {
		if(Me.me == null) {
			Me.me = new Me();
		}
		return Me.me;
	}

	public static Me getMe() {
		return me;
	}

	public static void setMe(Me me) {
		Me.me = me;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
