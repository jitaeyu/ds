package com.ktdsuniversty.edu.datetime.mart;

import com.ktdsuniversty.edu.datetime.kakao.Base;

public class MartTest {

	public static void main(String[] args) {

		Store store = new Store();
		store.add(new Item("초코에몽", "2026-02-03"));
		store.add(new Item("딸기에몽", "2026-02-04"));
		store.add(new Item("밀크에몽", "2026-02-05"));
		store.add(new Item("바나나에몽", "2026-02-06"));
		store.add(new Item("메론에몽", "2026-02-07"));
		
		store.sell(Base.FUTURE);
		store.sell(Base.NOW);
		store.sell(Base.PAST);
		
//		--실행 결과값--
//		밀크에몽가능한 빨리드세요
//		바나나에몽가능한 빨리드세요
//		메론에몽가능한 빨리드세요
//		딸기에몽오늘 까지 드세요
//		초코에몽소비기한이 지나 판매하지않습니다

		
		

	}

}
