package com.ktdsuniversty.edu.datetime;

import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		
		int year = now.get(Calendar.YEAR);
		System.out.println(year);
		int month = now.get(Calendar.MONTH);
		System.out.println(month);
		int date = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(date);
		
		
		//1(월요일) ~ 7(토요일)
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		
		String[] weekDays = {"월","화","수","목","금","토"};
		System.out.println(weekDays[week-1]+"요일");
		
		//1996-04-22 (??)
		Calendar birthdate = Calendar.getInstance();
		birthdate.set(1996, 4-1, 22);
		week=birthdate.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekDays[week-1]+"요일");
		
		//오늘 날짜부터 56일 후는 몇월 몇일 무슨 요일일까?
		Calendar now2 = Calendar.getInstance();
		now2.add(Calendar.DAY_OF_MONTH, 56);
		
		//25년 2월4일은 2026년 2월 4일보다 과거인가?
		Calendar past = Calendar.getInstance();
		past.set(2025,2-1,4);
		
		
		//now3의 시간이 1970년 01월01일 0시0분0초 부터 얼마나 흘렀나?
		Calendar now3 = Calendar.getInstance();
		long nowTime = now3.getTimeInMillis();
		System.out.println(nowTime);
		
		long pastTime = past.getTimeInMillis();
		System.out.println(pastTime);
		
		if(pastTime<nowTime) {
			System.out.println("더 과거입니다.");
		}
		Calendar now4 = Calendar.getInstance();
		
		int businessDay=7;
		int weekdays=0;
		while(businessDay>7) {
			now4.add(Calendar.DAY_OF_MONTH,1);
			week = now4.get(Calendar.DAY_OF_WEEK);
			if(week != 1 && week !=7) {
				businessDay --;
			}
		}
		
		int nextYear = now4.get(Calendar.YEAR);
		int nextMonth = now4.get(Calendar.MONTH);
		int nextDate = now4.get(Calendar.DAY_OF_MONTH);
		weekdays = now4.get(Calendar.DAY_OF_WEEK);
		System.out.println(nextYear+"-"+nextMonth+"-"+nextDate+"-"+weekDays[weekdays-1]+"요일");
				
		
		
	}
	
}
