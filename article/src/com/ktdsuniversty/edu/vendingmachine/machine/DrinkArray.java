package com.ktdsuniversty.edu.vendingmachine.machine;

import com.ktdsuniversty.edu.vendingmachine.item.Drink;

public class DrinkArray {
	
	Drink[] drinks;
	private int insertMoney;
	
	
	
	public DrinkArray(Drink bak, Drink mon, Drink hot, Drink mink) {
		this.drinks = new Drink[4];
		this.drinks[0] = bak;
		this.drinks[1] = mon;
		this.drinks[2] = hot;
		this.drinks[3] = mink;
	}

	
	
	
	public int getInsertMoney() {
		return insertMoney;
	}




	public void setInsertMoney(int insertMoney) {
		this.insertMoney = insertMoney;
	}




	public int orderDrink(int drinkId, int quantity,int insertMoney) {
		this.insertMoney=insertMoney;
		
		int inv = searchInventory(drinkId);
		if(drinkId<=0 || drinkId >= this.drinks.length) {
			if(inv>quantity) {
				outInventory(drinkId,quantity);
				return drinks[drinkId].getPrice()*quantity;
			}else {
				System.out.println("재고가 없습니다");
				return 0;
			}
		}
		return 0;
		
		
//		return int구매금액!!!!;
	}
	
	public void getInventory (int drinkId, int quantity) {
//		if(drinkId<=0 || drinkId >= this.drinks.length){
		int inventroySum = drinks[drinkId].getInventory()+quantity;
		drinks[drinkId].setInventory(inventroySum);

//			drinks[drinkId].getInventory() +=quantity;
//		}
	}
	public void outInventory(int drinkId, int quantity) {
		if(drinkId<=0 || drinkId >= this.drinks.length) {
			int inventorySave = drinks[drinkId].getInventory()+quantity;
			drinks[drinkId].setInventory(inventorySave);
//			drinks[drinkId].inventory -=quantity;
		}
	}
	
	public int searchInventory(int drinkId) {
		return drinks[drinkId].getInventory();
//		return drinks[drinkId].inventory;
	}
	
}
