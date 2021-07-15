package com.shopping.SportsShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.SportsShoes.model.Customer;



@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
	Customer findByEmail(String emailAddress);
}
