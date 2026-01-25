package report.restaurant.custumer;

public class Custumer {

	private String name;
	private double drunken;
	private int satiety;
	private int money;
	
	public Custumer(String name, double drunken, int satiety, int money) {
		this.name=name;
		this.drunken=drunken;
		this.satiety=satiety;
		this.money=money;
	}
	
	public String getName() {
		return this.name;
	}
	public double getDrunken() {
		return this.drunken;
	}
	public int getSatiety() {
		return this.satiety;
	}
	public int getMoney() {
		return this.money;
	}
	
	public void setDrunken(double drunken) {
		this.drunken=drunken;
	}
	public void setSatiety(int satiety) {
		this.satiety=satiety;
	}
	public void setMoney(int money) {
		this.money=money;
	}
	
}
