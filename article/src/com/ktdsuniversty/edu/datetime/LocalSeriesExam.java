package com.ktdsuniversty.edu.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalSeriesExam {
	public static void main(String[] args) {
			/*
			 * LocalDate : 
			 * LocalTime:
			 * LocalDateTime: 
			 */
			//현재 날짜를 출력
		LocalDate nowDate = LocalDate.now();
		System.out.println(nowDate);
		
			//현재 시간을 출력
		LocalTime nowTime = LocalTime.now();
		System.out.println(nowTime);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime= dtf.format(nowTime);
		System.out.println("formattedTime: "+formattedTime);
		
			//현재 날짜와 시간을 출력.
		LocalDateTime nowDateTime = LocalDateTime.now();
		System.out.println(nowDateTime);
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd E요일 HH:mm:ss");
		String fomattedDateTime = dtf.format(nowDateTime);
		System.out.println("fomattedDateTime: "+fomattedDateTime);
		
		//태어난 일이 무슨요일인가
		LocalDate birthday3 = LocalDate.of(1996, 4, 22);
		System.out.println("birthday3"+birthday3);
		DayOfWeek week = birthday3.getDayOfWeek();
		System.out.println("week : "+week);
		dtf = DateTimeFormatter.ofPattern("E요일");
		String weekString = dtf.format(birthday3);
		System.out.println("weekString: "+weekString);
		
		LocalDate birthday = LocalDate.parse("1996-04-22");
		System.out.println(birthday);
		int birthdayYear = birthday.getYear();
		System.out.println(birthdayYear);
		
		
		LocalDate birthday2 = LocalDate.parse("1996년 04월 22일",DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		System.out.println(birthday2);
		
		
		//오늘날짜부터 19일 이후가 언제인가
		LocalDate future = LocalDate.now().plusDays(19);
		System.out.println(future);
		//오늘날짜부터 35년 후가 언제인가?
		future=LocalDate.now().plusYears(35);
		System.out.println(future);
		// 오늘 날짜로부터 97년전은 언제인가?
		LocalDate past = LocalDate.now().minusYears(97);
		System.out.println(past);
		//오늘 날짜로부터 1300개월 이후는 언제인가?
		future=LocalDate.now().plusMonths(1300);
		System.out.println(future);
		//2025년 1월 1일은 2026년 1월1일보다 과거인가?
		LocalDate date1 = LocalDate.parse("2025-01-01");
		LocalDate date2 = LocalDate.parse("2026-01-01");
		System.out.println(date1.isBefore(date2));
		//2026 12월11일은 2025 2월5일보다 미래인가
		LocalDate date3 = LocalDate.parse("2026-12-11");
		LocalDate date4 = LocalDate.parse("2025-02-05");
		System.out.println(date3.isAfter(date4));
		
		Period period=Period.between(date3, date4);
		System.out.println(period);
		System.out.println(period.getYears());

		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		
		
		long betweenDays=ChronoUnit.DAYS.between(date3, date4);
		System.out.println(betweenDays);
		
		long betweenDays2= ChronoUnit.YEARS.between(date3, date4);
		System.out.println(betweenDays2);
	}
}
