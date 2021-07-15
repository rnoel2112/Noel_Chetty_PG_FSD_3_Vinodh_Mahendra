package com.shopping.SportsShoes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.SportsShoes.model.Category;
import com.shopping.SportsShoes.model.Product;
import com.shopping.SportsShoes.repository.CategoryRepository;
import com.shopping.SportsShoes.repository.ProductRepository;
import com.shopping.SportsShoes.service.ProductServiceImpl;

@SpringBootApplication
public class SportsShoesApplication implements CommandLineRunner {

	@Autowired
	private ProductServiceImpl productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SportsShoesApplication.class, args);
 	}
	

	@Override
	public void run(String... args) throws Exception {

		/*
		Date mfDate = new Date ("21/10/2021");
		float size = (float) 10.5;
		
		Product product =new Product( 	"MenShoe",
										"Mens Sport Shoe",
										"Nike", 
										size,
										size,
										"Blue",
										mfDate,
										mfDate);
		
		Category cat1=new Category("menShoes", "Men Shoes");
		product.setCategory(cat1);

		productRepository.saveProduct(product);

		 */
	}
	
		
}
