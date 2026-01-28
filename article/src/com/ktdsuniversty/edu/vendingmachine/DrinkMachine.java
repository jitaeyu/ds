package com.ktdsuniversty.edu.vendingmachine;

import com.ktdsuniversty.edu.vendingmachine.item.Drink;
import com.ktdsuniversty.edu.vendingmachine.item.Refund;
import com.ktdsuniversty.edu.vendingmachine.machine.DrinkArray;

public class DrinkMachine {

	public static void main(String[] args) {
		Drink bak = new Drink("박카스", 900, 15);
		Drink mon = new Drink("몬스터", 1500, 20);
		Drink hot = new Drink("핫식스", 1300, 10);
		Drink milk = new Drink("밀키스", 1400, 5);
		
		DrinkArray goodDrink = new DrinkArray(bak, mon, hot, milk);
		
		DrinkArray refundMuchine = new Refund(bak, mon, hot, milk);
		int price = goodDrink.orderDrink(0, 5,5000);
		if(refundMuchine instanceof Refund gogo) {
			int aa=gogo.orderDrink(0, 5, 5000);
			int bb=gogo.refundMoney(aa);
			System.out.println("환불금액은:"+bb);
		}
		
		int findInventory1 = goodDrink.searchInventory(0);
		int findInventory2 = goodDrink.searchInventory(1);
		int findInventory3 = goodDrink.searchInventory(2);
		int findInventory4 = goodDrink.searchInventory(3);
		System.out.println("구매완료 구매금액은: "+price);
		goodDrink.getInventory(0, 50);//박카스재고 5개추가
		
		int findInventory5 = goodDrink.searchInventory(0);

	
		System.out.print("사먹은박카스재고: "+findInventory1+"   ");
		System.out.print("몬스터재고: "+findInventory2+"   ");
		System.out.print("핫식스재고: "+findInventory3+"   ");
		System.out.println("밀키스재고: "+findInventory4+"   ");
		
		System.out.print("채운 박카스재고2: "+findInventory5+"   ");
		
	}
}
