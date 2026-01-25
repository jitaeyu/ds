package report.restaurant.data;

import report.restaurant.custumer.Custumer;
import report.restaurant.menu.Menu;

public class ContentData {
	
	private Custumer custumer0 = new Custumer("손님1", 0.0, 0, 5000);
	private Custumer custumer1 = new Custumer("손님2", 0.0, 0, 8000);
	private Custumer custumer2 = new Custumer("손님3", 0.0, 0, 1000000);
//	private Custumer custumer4 = new Custumer("손님4", 0.0, 0, 5000);
	
	private Menu menu0 = new Menu(1,"주류", 5000, 19.0, 50,10.0,1000);
	private Menu menu1 = new Menu(1,"주류", 6000, 6.0, 100,10.0,1000);
	private Menu menu2 = new Menu(1,"주류", 5000, 40.0, 25,10.0,1000);
	private Menu menu3 = new Menu(2,"식사류", 10000, 500, 15,50.0,1000);
	private Menu menu4 = new Menu(2,"식사류", 8000, 300, 10,50.0,1000);

	
	
	public Custumer getCustumer0() {
		return custumer0;
	}
	public Custumer getCustumer1() {
		return custumer1;
	}
	public Custumer getCustumer2() {
		return custumer2;
	}
//	public Custumer getCustumer3() {
//		return custumer3;
//	}
	public Menu getMenu0() {
		return menu0;
	}
	public Menu getMenu1() {
		return menu1;
	}
	public Menu getMenu2() {
		return menu2;
	}
	public Menu getMenu3() {
		return menu3;
	}
	public Menu getMenu4() {
		return menu4;
	}
	
	
	
	
	
}
