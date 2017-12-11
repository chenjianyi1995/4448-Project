package com.roverandfriends.model;

import com.roverandfriends.controller.UserController;
import com.sun.istack.internal.logging.Logger;

public class Cart implements ShoppingCart{
	
	final static Logger logger = Logger.getLogger(UserController.class);
	public int item_number = 0;
	
	
	public void addtocart() {
		item_number = item_number +1;
		System.out.println("Item: "+item_number);
		logger.info("******************************************" + "Item: "+item_number);
	}

	public void removefromcart() {
		item_number = item_number -1;
		System.out.println("Item: "+item_number);
		logger.info("******************************************" + "Item: "+item_number);
	}

	public int getItem_number() {
		return item_number;
	}

	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}
	
	

}
