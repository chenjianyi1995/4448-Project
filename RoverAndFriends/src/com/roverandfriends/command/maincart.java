package com.roverandfriends.command;
import java.util.ArrayList;
import java.util.List;

import com.roverandfriends.model.AddToCart;
import com.roverandfriends.model.ExecuteCommand;
import com.roverandfriends.model.Getshoppingcart;
import com.roverandfriends.model.RemoveFromCart;
import com.roverandfriends.model.ShoppingCart;

public class maincart {
	public static void main(String[] args) {
		ShoppingCart newCart = Getshoppingcart.getShoppingCart();
		
		AddToCart addCommand = new AddToCart(newCart);
		ExecuteCommand onexcute = new ExecuteCommand(addCommand);
		onexcute.E_excute();
		onexcute.E_undo();
		onexcute.E_excute();
		onexcute.E_excute();
		onexcute.E_undo();
		RemoveFromCart removeCommand = new RemoveFromCart(newCart);
		ExecuteCommand R_execute = new ExecuteCommand(removeCommand);
		R_execute.E_excute();
		R_execute.E_undo();
	
	}
}