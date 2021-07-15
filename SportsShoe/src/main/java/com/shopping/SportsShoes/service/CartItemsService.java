package com.shopping.SportsShoes.service;

import java.util.List;

import com.shopping.SportsShoes.model.CartItems;

public interface CartItemsService {
	
	List<CartItems> getAllProducts();

	void saveCart(CartItems aProduct);
	
	CartItems getCartItemById(long id);
	
	void deleteCartItemsById(long id);
	
	CartItems getCartItemByProductId(long id);
	
	void deleteAllItems();

}

