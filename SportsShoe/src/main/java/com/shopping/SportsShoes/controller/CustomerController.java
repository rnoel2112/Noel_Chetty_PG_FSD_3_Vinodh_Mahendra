package com.shopping.SportsShoes.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.shopping.SportsShoes.model.CartItems;
import com.shopping.SportsShoes.model.Customer;
import com.shopping.SportsShoes.model.PaymentDetails;
import com.shopping.SportsShoes.model.Product;
import com.shopping.SportsShoes.service.CartItemsService;
import com.shopping.SportsShoes.service.CustomerService;
import com.shopping.SportsShoes.service.ProductService;



@Controller
public class CustomerController {
	

	@Autowired
	private CustomerService aCustomerService;
	
	@Autowired
	private ProductService aProductService;
	
	@Autowired
	private CartItemsService aCartItemService;
	
	//get all customers
	@GetMapping("/customerlist")
	public String viewCustomers(Model aCustModel){
		aCustModel.addAttribute("listCustomers",aCustomerService.getAllCustomers());
		return "customers";
		
	}
	
	@GetMapping("/customerregisteration")
	public String showCustomerRegisterationForm(Model model) {
		
		List<CartItems> listOfCartItems = aCartItemService.getAllProducts();
		
		if (listOfCartItems.isEmpty()) 
			return "redirect:/index";
		
		Customer aCust = new Customer();
		model.addAttribute("customer", aCust);
		
		return "customerregisteration";
	}
	
	@PostMapping("/customervalidate")
	public String customerRegisteration( @ModelAttribute("customer") Customer aCust,Model aModel) {
		
		   
		if (	aCust.getEmail().isEmpty() ||
				aCust.getFirstName().isEmpty()||
				aCust.getLastName().isEmpty()||
				aCust.getPhoneNo().isEmpty()||
				aCust.getPassword().isEmpty()

		) {
					aModel.addAttribute("error","Please enter missing details");
					aModel.addAttribute("condition","false");
					return("customerregisteration");
					
		} else {
			
			Customer existingCustomer =aCustomerService.getCustomerByEmail(aCust.getEmail()); 
			
			if ( (existingCustomer == null ) || 
				 (existingCustomer != null && !aCust.getEmail().equals(existingCustomer.getEmail()))
			) { 
				aCustomerService.saveCustomer(aCust);	
			}
			
			aModel.addAttribute("error","");
			aModel.addAttribute("condition","true");
								
			CartItems aCartItem;
			Product aProduct;
		
			HashMap <CartItems,Product > myCartDict = new HashMap<CartItems,Product >();
		 
			List<CartItems> listOfCartItems = aCartItemService.getAllProducts();
			Iterator<CartItems> aCartIterator = listOfCartItems.iterator();
        
			float totalPrice = 0;
   
			while (aCartIterator.hasNext()) {
        	
				aCartItem = aCartIterator.next();
				aProduct = aProductService.getProductById(aCartItem.getProductId());
				myCartDict.put(aCartItem, aProduct);
				totalPrice += aCartItem.getUnitPrice()* aCartItem.getQuantity();
			}

			aModel.addAttribute("payitems",myCartDict);
			aModel.addAttribute("totalamount",String.valueOf(totalPrice));
		}
		return "paymentsummary";
	}
	
	
	@PostMapping("/paynow")
	public String showCustomerPaymentForm(@ModelAttribute("totalamount") String totalamount, 
			Model model) {
		//@RequestParam(value = "totalamount", required = false) String totalamount1,
		
		PaymentDetails aPaymentDetails = new PaymentDetails();
		model.addAttribute("paymentdetails", aPaymentDetails);
		model.addAttribute("totalPrice", totalamount);
		model.addAttribute("condition","true");
		model.addAttribute("error","");

		
		return "payment";
	}
	
	
	@PostMapping("/paymentvalidate")
	public String paymentValidation( @ModelAttribute("paymentdetails") PaymentDetails aPayment,Model aModel) {
		
	   
		if (	aPayment.getEmail().isEmpty() ||
				aPayment.getFirstName().isEmpty()||
				aPayment.getLastName().isEmpty()||
				aPayment.getCardNo().isEmpty()||
				aPayment.getExpiryDate().isEmpty()

		) {
			aModel.addAttribute("error","Please enter missing details");
			aModel.addAttribute("condition","false");
			return "payment";
			
		}
		
		// remove items from basket	
		aCartItemService.deleteAllItems();
		
		aModel.addAttribute("error","Thank you, the product will be delivered soon ");
		aModel.addAttribute("condition","true");
		aModel.addAttribute("paymentdetails", aPayment);
		return "confirm";	
	}
	
}
