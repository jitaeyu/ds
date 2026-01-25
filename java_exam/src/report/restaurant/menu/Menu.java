package report.restaurant.menu;

public class Menu {

	private int menuId;
	private String menuName;
	private int price;
	private double alc;
	private int stock;
	private double maxAlc;
	private int maxFull;
	
	public Menu(int menuId, String menuName,int price,double alc, int stock,double maxAlc, int maxFull) {
		this.menuId=menuId;
		this.menuName=menuName;
		this.price=price;
		this.alc=alc;
		this.stock=stock;
		this.maxAlc=maxAlc;
		this.maxFull=maxFull;
	}
	public int getMenuId() {
		return this.menuId;
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
