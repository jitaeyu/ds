package kakao;

import java.time.LocalDate;
import java.time.Period;

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
		
//		fl.printFriends(Base.FUTURE);//생일다가오는
//		fl.printFriends(Base.NOW);//생일인
//		fl.printFriends(Base.PAST);//생일지난
		
		System.out.println("7일 이내에 생일을 맞이하는 친구 목록");
//		fl.printFriends( birthdate -> birthdate.isAfter(LocalDate.now())
//												&& birthdate.isBefore(LocalDate.now().minusDays(8)));;
		fl.printFriends2( friend -> {
			LocalDate birthdate = friend.getBirthdate().withYear(LocalDate.now().getYear());
			return birthdate.isAfter(LocalDate.now())
					&& birthdate.isBefore(LocalDate.now().plusDays(8));
		});
		System.out.println("오늘이 생일인 친구 목록");
//		fl.printFriends(birthdate -> birthdate.isEqual(LocalDate.now()));
		fl.printFriends2(friend ->{
			LocalDate now = LocalDate.now();
			LocalDate birthdate = friend.getBirthdate().withYear(now.getYear());
			
			return birthdate.isEqual(now);
		});
		System.out.println("7일 이내에 생일이 지난 친구 목록");
//		fl.printFriends(birthdate -> birthdate.isBefore(LocalDate.now())
//												&& birthdate.isAfter(LocalDate.now().minusDays(8)));	
		fl.printFriends2(friend ->{
			LocalDate now = LocalDate.now();
			LocalDate lateBirthdate = friend.getBirthdate().withYear(now.getYear());
			return lateBirthdate.isBefore(LocalDate.now())
					&& lateBirthdate.isAfter(LocalDate.now().minusDays(8));
		});
		
		System.out.println("오늘 만 30세가 된 친구목록");
		fl.printFriends2(friend ->{
			Period period = Period.between(friend.getBirthdate(), LocalDate.now());
			return period.getYears() == 30 && period.getMonths() == 0 && period.getDays()==0;});
		
		System.out.println("전체 친구목록");
		fl.printFriends2(friend ->true);
		
		System.out.println("이름이 A인 친구목록");
		fl.printFriends(friend ->friend.getName().equals("A"));
		
		System.out.println("이름이 김으로 시작하는 친구목록");
		fl.printFriends2(friend -> friend.getName().startsWith("김"));
		
//		System.out.println(fl);
	}

}
