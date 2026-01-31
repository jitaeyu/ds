package report.restaurant.restaurant;

import report.restaurant.custumer.Custumer;
import report.restaurant.data.ContentData;
import report.restaurant.exceptions.ArrayException;
import report.restaurant.exceptions.DrunkenException;
import report.restaurant.exceptions.FullException;
import report.restaurant.exceptions.MoneyException;
import report.restaurant.exceptions.StockException;
import report.restaurant.menu.Menu;

public class Restaurant {

	Custumer[] custumer;
	Menu[] menu;
	int totalSales = 0;
	int custumerMoney = 0;
	int menuPrice = 0;
	int menuStock = 0;

	public Restaurant(ContentData data) {
		this.custumer = new Custumer[3];
		this.custumer[0] = data.getCustumer0();
		this.custumer[1] = data.getCustumer1();
		this.custumer[2] = data.getCustumer2();
		this.menu = new Menu[5];
		this.menu[0] = data.getMenu0();
		this.menu[1] = data.getMenu1();
		this.menu[2] = data.getMenu2();
		this.menu[3] = data.getMenu3();
		this.menu[4] = data.getMenu4();
	}

	public double maxAlc() {
		return menu[0].getMaxAlc();
	}

	public int maxFull() {
		return menu[0].getMaxFull();
	}

	public int fullCheck(int custumerId) {
		return custumer[custumerId].getSatiety();
	}

	public double drunkCheck(int custumerId) {
		return custumer[custumerId].getDrunken();
	}

	public int menuStockCheck(int menuNumber) {
		return menu[menuNumber].getStock();
	}

	public int custumerMoney(int custumerId) {
		return custumer[custumerId].getMoney();
	}

	public int MenuPrice(int menuNumber) {
		return menu[menuNumber].getPrice();
	}

	public void totalSell() {
		System.out.println("총 매출액 : " + totalSales);
	}

	public double menuAlc(int menuNumber) {
		return menu[menuNumber].getAlc();
	}

	public void sellMenuStock(int menuNumber) {
		menu[menuNumber].setStock((menuStockCheck(menuNumber) - 1));
	}

	public int menuFood(int menuNumber) {
		return (int) menu[menuNumber].getAlc();
	}

	public void payForEat(int custumerId, int menuNumber) {
		custumer[custumerId].setMoney(custumerMoney(custumerId) - MenuPrice(menuNumber));
	}

	public void showCustumer() {
		System.out.println("------손님-------");
		for (int i = 0; i < custumer.length; i++) {
			Custumer c = custumer[i];
			System.out.print(c.getName());
			System.out.print(" " + c.getSatiety());
			System.out.print(" " + c.getDrunken());
			System.out.print(" " + c.getMoney());
			System.out.println();
		}
	}

	public void showMenu() {
		double maxAlc = maxAlc();
		int maxFull = maxFull();
		System.out.println("------식당-------");
		for (int i = 0; i < menu.length; i++) {
			Menu m = menu[i];
			System.out.print(m.getmenuName());
			System.out.print(" " + m.getPrice());
			System.out.print(" " + m.getAlc());
			System.out.print(" " + m.getStock());
			System.out.println();
		}
		System.out.println(" ");
		System.out.println("식당 취함기준 : " + maxAlc);
		System.out.println("식당 배부름기준 : " + maxFull);
	}

	public boolean ceoChecker(int custumerId) {
		int custumerFullCheck = fullCheck(custumerId);
		double custumerDrunkCheck = drunkCheck(custumerId);
		double ceoAlcCheck = menu[0].getMaxAlc();
		int ceoFullCheck = menu[0].getMaxFull();
		if (custumerFullCheck < ceoFullCheck && custumerDrunkCheck < ceoAlcCheck) {
			return true;
		} else {
			if (custumerDrunkCheck < ceoFullCheck) {
				throw new FullException("배가 너무많이 차서 입장이거부되었습니다");
//				System.err.println("배가 너무많이 차서 입장이거부되었습니다");
			} else {
				throw new DrunkenException("너무 취해서 입장이 거부되었습니다");
//				System.err.println("너무 취해서 입장이 거부되었습니다.");
			}
		}

	}

	public boolean orderPayCheck(int custumerId, int menuNumber) {
		custumerMoney = custumer[custumerId].getMoney();
		menuPrice = menu[menuNumber].getPrice();
		menuStock = menuStockCheck(menuNumber);

		if (custumerMoney >= menuPrice && menuStock >= 1) {
			return true;
		} else if (menuStock < 1) {
			throw new StockException("메뉴 재고부족으로 주문실패");
//			System.err.println(menu[menuNumber].getmenuName()+"메뉴 재고부족으로 주문실패");
//			return false;
		} else if (custumerMoney < menuPrice) {
			throw new MoneyException("메뉴를 주문하기엔 돈이 모자라서 주문실패");
//			System.err.println(menu[menuNumber].getmenuName()+"메뉴를 주문하기엔 돈이 모자라서 주문실패");
//			return false;
		} else {
			return false;
		}
	}

	public void custurmerOrder(Integer custumerId, Integer menuNumber) {
		if (custumerId < 0 || custumerId >= custumer.length) {
//		    System.out.println("메뉴 번호가 유효하지 않습니다: " + custumerId);
		   throw new ArrayException("손님의 번호를 잘못입력했습니다");
		}
		if (menuNumber < 0 || menuNumber >= menu.length) {
//		    System.out.println("메뉴 번호가 유효하지 않습니다: " + menuNumber);
			throw new ArrayException("메뉴의 번호를 잘못입력했습니다");
		}

		
		if (custumerId == null) {
			throw new NullPointerException("손님의번호는 null일수없습니다");
		}
		if(menuNumber == null) {
			throw new NullPointerException("메뉴번호는 null일수없습니다");
		}

		boolean orderCheck = orderPayCheck(custumerId, menuNumber);
		boolean ceoCheck = ceoChecker(custumerId);
		if (ceoCheck) {// 배고프고 안취했음
			if (orderCheck) {// 돈있고 재고도있어
				// 식당 배부름,취함 찾아서 손님에게 set으로 추가하고 -->돈도 매출로 추가하고 재고도 줄여야해
				eatMenu(custumerId, menuNumber);
				sellMoneyAndStock(custumerId, menuNumber);
				// System.out.println("누적매출금"+totalSales);
			}
		}

	}

	public void sellMoneyAndStock(int custumerId, int menuNumber) {
		// set 사용자 돈 - 메뉴의 값
		payForEat(custumerId, menuNumber);
		// set 메뉴 재고-1;
		sellMenuStock(menuNumber);
		// 리턴값은 매출
		int price = menu[menuNumber].getPrice();
		totalSales += price; // 누적 합계
	}

	public void eatMenu(int custumerId, int menuNumber) {
		int menuId = menu[menuNumber].getMenuId();
		if (menuId == 1) {// 1이면주류 취기올려d
			eatAlcMenu(custumerId, menuNumber);
		} else {// 아니면(입력값2)음식 포만감올려
			eatFoodMenu(custumerId, menuNumber);
		}

	}

	public void eatAlcMenu(int custumerId, int menuNumber) {
		double custumerDrunken = drunkCheck(custumerId);
		double menuAlc = menuAlc(menuNumber) * 0.1;
		custumer[custumerId].setDrunken(custumerDrunken + menuAlc);
	}

	public void eatFoodMenu(int custumerId, int menuNumber) {
		int custumerfull = fullCheck(custumerId);
		int menuFull = menuFood(menuNumber);
		custumer[custumerId].setSatiety(custumerfull + menuFull);
	}

	public void showAll() {
		System.out.println("================");
		showCustumer();
		showMenu();
		totalSell();
		System.out.println("================");
	}
}
