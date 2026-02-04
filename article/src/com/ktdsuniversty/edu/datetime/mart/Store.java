package com.ktdsuniversty.edu.datetime.mart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversty.edu.datetime.kakao.Base;

public class Store {

	private List<Item> items ;
	
	public Store() {
		this.items=new ArrayList<Item>();
	}
	
	public void add(Item item) {
		this.items.add(item);
		// 추가
	}
	LocalDate tempDay=null;
	public void sell(Base base) {
		for (Item i : items) {
			tempDay = LocalDate.parse(i.getExpireDate().toString());
			tempDay = tempDay.withYear(LocalDate.now().getYear());
			if(base==Base.FUTURE) {
				//소비기한이 3일내에 도래한다면
				if(tempDay.isAfter(LocalDate.now())
						&& tempDay.isBefore(LocalDate.now().plusDays(4))) {
					System.out.println(i.getName()+"가능한 빨리드세요");
//		"가능한 빨리드세요출력"
				}
				
			}else if(base == Base.NOW) {
				//index에 할당되어있는 제품의 소비기한이 당일이라면 
				if(tempDay.isEqual(LocalDate.now())) {
					System.out.println(i.getName()+"오늘 까지 드세요");
					//오늘 까지 드세요 를 출력한다 
				}
				
			}else if(base == Base.PAST) {
				//소비기한이 지났다면
				if(tempDay.isBefore(LocalDate.now())) {
					System.out.println(i.getName()+"소비기한이 지나 판매하지않습니다");
//		"소비기한이 지나 판매하지않습니다 출력"
				}
				
			}
			
			
			
			
		}
		
	}
	
	
}
