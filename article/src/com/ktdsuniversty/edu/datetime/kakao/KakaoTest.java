package com.ktdsuniversty.edu.datetime.kakao;

public class KakaoTest {

	public static void main(String[] args) {

		FriendList fl = new FriendList();
		fl.add(new Friend("A", "2000-01-01"));
		fl.add(new Friend("B", "2001-11-11"));
		fl.add(new Friend("C", "2002-12-12"));
		fl.add(new Friend("D", "2003-04-21"));
		fl.add(new Friend("E", "2004-07-09"));
		fl.add(new Friend("F", "2020-02-04"));
		fl.add(new Friend("G", "2003-01-30"));
		fl.add(new Friend("H", "2004-02-01"));
		
		fl.printFriends(Base.FUTURE);//생일다가오는
		fl.printFriends(Base.NOW);//생일인
		fl.printFriends(Base.PAST);//생일지난
		
		
//		System.out.println(fl);
	}

}
