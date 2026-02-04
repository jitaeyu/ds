package com.ktdsuniversty.edu.datetime.mart;

import java.time.LocalDate;

public class Item {

	private String name;
	private LocalDate expireDate;
	
	//생성자
	
	public Item(String name, String expireDay) {
		this.name=name;
		this.expireDate=LocalDate.parse(expireDay);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "상품명: " + name + " 소비기한" + expireDate;
	}
	//g s to
}
