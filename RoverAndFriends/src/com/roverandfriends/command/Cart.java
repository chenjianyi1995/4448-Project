package com.roverandfriends.command;

public class Cart implements ShoppingCart{
	private int item_number = 0;
	public void addtocart() {
		item_number = item_number +1;
		System.out.println("Item: "+item_number);
		
	}

	public void removefromcart() {
		item_number = item_number -1;
		System.out.println("Item: "+item_number);
	}

}
