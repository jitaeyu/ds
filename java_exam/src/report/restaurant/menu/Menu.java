package report.restaurant.menu;

import report.restaurant.alcenum.FoodCheck;

public class Menu {

	private FoodCheck foodcheck;
	private String menuName;
	private int price;
	private double alc;
	private int stock;
	private double maxAlc;
	private int maxFull;
	
	public Menu(FoodCheck foodcheck, String menuName,int price,double alc, int stock,double maxAlc, int maxFull) {
		this.foodcheck=foodcheck;
		this.menuName=menuName;
		this.price=price;
		this.alc=alc;
		this.stock=stock;
		this.maxAlc=maxAlc;
		this.maxFull=maxFull;
	}

	public FoodCheck getFoodcheck() {
		return this.foodcheck;
	}
	public String getmenuName() {
		return this.menuName;
	}
	public int getPrice() {
		return this.price;
	}
	public double getAlc() {
		return this.alc;
	}
	public int getStock() {
		return this.stock;
	}
	public double getMaxAlc() {
		return this.maxAlc;
	}
	public int getMaxFull() {
		return this.maxFull;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	
}
