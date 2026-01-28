package report.store;


public class Mart {
	Mart mart;
//	Vo[] marts;
//	
//	public Mart(Vo p1, Vo p2, Vo p3, Vo p4) {
//		this.marts = new Vo[4];
//		this.marts[0] = p1;
//		this.marts[1] = p2;
//		this.marts[2] = p3;
//		this.marts[3] = p4;
//		Mart realmart = new Mart(p1, p2, p3, p4);
		
	private String name;
	private int price;
	private int inventory;
	private int inputMoney;
	
//	}
	public Mart(String name,int price, int inventory,int inputMoney) {
		this.name=name;
		this.price=price;
		this.inventory=inventory;
		this.inputMoney=inputMoney;
	}
	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private int getPrice() {
		return price;
	}

	private void setPrice(int price) {
		this.price = price;
	}

	private int getInventory() {
		return inventory;
	}

	private void setInventory(int inventory) {
		this.inventory = inventory;
	}

	private int getInputMoney() {
		return inputMoney;
	}

	private void setInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}
	
	
	
	public int sell(String name, int inputMoney) {
//		mart.setInputMoney(inputMoney);
		
		if(mart.getInventory()>0) {
			//구매가능
			if(mart.getInputMoney()>=mart.getPrice()) {
				//구매가능
				mart.setInventory(mart.getInventory()-1);//팔았다
				int sum=mart.getInputMoney()-mart.getPrice();
				System.out.println("거스름돈:"+sum);
				return sum;
				
			}else {
				System.out.println("그돈으론 아무것도 못사요");
			}
		}else {
			System.out.println("재고부족");
		}
		return 0;
	}
	
	

}
