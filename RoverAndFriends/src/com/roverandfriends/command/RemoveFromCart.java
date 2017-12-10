package com.roverandfriends.command;


public class RemoveFromCart implements Command{
	ShoppingCart theCart;
	public RemoveFromCart(ShoppingCart newCart) {
		theCart = newCart;
	}
	
	public void execute() {
		theCart.removefromcart();
	}
	public void undo() {
		theCart.addtocart();
	}

}
