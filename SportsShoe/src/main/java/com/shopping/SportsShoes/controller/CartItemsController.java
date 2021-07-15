package com.shopping.SportsShoes.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.shopping.SportsShoes.model.CartItems;
import com.shopping.SportsShoes.model.Product;
import com.shopping.SportsShoes.service.CartItemsService;
import com.shopping.SportsShoes.service.ProductService;

@Controller
public class CartItemsController {


	@Autowired
	private ProductService aProductService;
	
	@Autowired
	private CartItemsService aCartItemService;
	
	@GetMapping("/checkout")
	public String viewCart(Model aCart){
		aCart.addAttribute("listcartitems",aCartItemService.getAllProducts());
		return "products";
		
	}

	
	@GetMapping("/addtoCart/{id}")
	public String saveCartItems (@PathVariable ( value = "id") long id, Model model) {
		
		Product aproduct = aProductService.getProductById(id);
		
		System.out.println ("Id recvied:" + id );
		System.out.println ("Product Id from database:" + aproduct.getId() );
		
		CartItems aCartItems = aCartItemService.getCartItemByProductId(aproduct.getId());
		
		if (aCartItems == null) {
			
			CartItems newItem = new CartItems();
			newItem.setProductId(aproduct.getId());
			newItem.setPaymentStatus(false);
			newItem.setQuantity(1);
			newItem.setUnitPrice(aproduct.getPrice());
			
			aCartItemService.saveCart(newItem);
			
		}else {
			aCartItems.setQuantity(aCartItems.getQuantity()+1);
			
			aCartItemService.saveCart(aCartItems);
			
		}
		
        List<CartItems> aCartlist = aCartItemService.getAllProducts();
        model.addAttribute("cartlist", aCartlist);
				
		return "redirect:/index";
	}
	
	
	@GetMapping("/updatecartform/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		
		return "updatecart";
	}
	
	@GetMapping("/deletecartitem/{id}")
	public String deleteCartItems(@PathVariable (value = "id") long id) {
		
		this.aCartItemService.deleteCartItemsById(id);
		return "redirect:/showcartitems";
	}
	
	
	
	@GetMapping("/showcartitems")
	public String viewCartItems(Model aCart){
		
	
		CartItems aCartItem;
		Product aProduct;
		 
		HashMap <CartItems,Product > myCartDict = new HashMap<CartItems,Product >();
		
		List<CartItems> listOfCartItems = aCartItemService.getAllProducts();
        Iterator<CartItems> aCartIterator = listOfCartItems.iterator();
        
      
        
        while (aCartIterator.hasNext()) {
        	
        	aCartItem = aCartIterator.next();
        	aProduct = aProductService.getProductById(aCartItem.getProductId());
      	
        	myCartDict.put(aCartItem, aProduct);
        	
        	System.out.println("Cart Item" + aCartItem);
        	System.out.println("Cart Product" + aProduct);
        }
        
		aCart.addAttribute("listcartitems",myCartDict);
		
		return "listcartitems";
		
	}
}
