package oop;

public class CoffeeShop {
	
	Coffee hot;
	Coffee ice;

	public CoffeeShop(Coffee hot, Coffee ice) {
		this.hot=hot;
		this.ice=ice;
	}
	public CoffeeShop() {
		this(new Coffee("기본 아메리카노", 1500),
				new Coffee("아아", 1500));
	}
	
//	public CoffeeShop() {
//		this.hot = new Coffee("기본 아메리카노", 1500);
//		this.ice = new Coffee("아아", 1500);
//	}
	
	/**
	 * 가장 첫번째 메뉴를 한개 주문한다.
	 * */
	public int orderCoffee() {
		int price = this.orderCoffee(0);
		return price;
	}

	public int orderCoffee(int menu) {
		int price = this.orderCoffee(menu,1);
		return price;
	}
	/**
	 * @param menu 메뉴들의 번호. 1:hot , 2:ice
	 * @param quantity 주문수량
	 * @return 주문가격
	 * */
	
	public int orderCoffee(int menu, int quantity) {
		if(menu==1) {
			System.out.println(this.hot.name+"음료를"+quantity+"개 주문받았습니다");
			return this.hot.price * quantity;
		}else if (menu==2) {
			System.out.println(this.ice.name+"음료를"+quantity+"개 주문받았습니다");
			return this.ice.price * quantity;
		}else {
			System.out.println("존재하지 않는 음료입니다");
			return 0;
		}
		
	}
	
}
