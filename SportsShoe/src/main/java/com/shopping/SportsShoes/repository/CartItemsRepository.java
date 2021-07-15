package com.shopping.SportsShoes.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.SportsShoes.model.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository <CartItems, Long> { 
	
	CartItems findByProductId(Long id);
}