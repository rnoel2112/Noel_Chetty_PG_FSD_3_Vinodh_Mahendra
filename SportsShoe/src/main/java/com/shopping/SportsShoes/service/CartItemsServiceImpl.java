package com.shopping.SportsShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.SportsShoes.model.CartItems;
import com.shopping.SportsShoes.repository.CartItemsRepository;

@Service
public class CartItemsServiceImpl implements CartItemsService {
	
	@Autowired
	private CartItemsRepository aCartItemsRepository;

	@Override
	public List<CartItems> getAllProducts() {
		return aCartItemsRepository.findAll();
	}

	@Override
	public void saveCart(CartItems aCart) {
		this.aCartItemsRepository.save(aCart);
		
	}

	@Override
	public CartItems getCartItemById(long id) {

		Optional <CartItems> optional = aCartItemsRepository.findById(id);
		CartItems aCart = null;
		if (optional.isPresent()) {
			aCart = optional.get();
		} else {
			// throw new RuntimeException("Cart not found for id : " + id);
			return null;
		}
		return aCart;
	}
		

	@Override
	public void deleteCartItemsById(long id) {
		this.aCartItemsRepository.deleteById(id);
		
	}

	@Override
	public CartItems getCartItemByProductId(long id) {
		
		return aCartItemsRepository.findByProductId(id);
	}

	@Override
	public void deleteAllItems() {
		this.aCartItemsRepository.deleteAll();
	}	
}
