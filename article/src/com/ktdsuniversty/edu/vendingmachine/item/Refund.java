package com.ktdsuniversty.edu.vendingmachine.item;

import com.ktdsuniversty.edu.vendingmachine.machine.DrinkArray;

public class Refund extends DrinkArray{
	



	
	public Refund(Drink bak, Drink mon, Drink hot, Drink mink) {
		super(bak, mon, hot, mink);
		// TODO Auto-generated constructor stub
	}

	public int refundMoney(int getMoney) {
		int sum =super.getInsertMoney()-getMoney;
		return sum;
	}
}
	
	

