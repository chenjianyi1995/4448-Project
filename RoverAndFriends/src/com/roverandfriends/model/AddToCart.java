package com.roverandfriends.model;

public class AddToCart implements Command {
	ShoppingCart theCart;
	public AddToCart(ShoppingCart newCart) {
		theCart = newCart;
	}
	public void execute() {
		theCart.addtocart();
	}
	public void undo() {
		theCart.removefromcart();
	}
}
