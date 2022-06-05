package com.jrp.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User found: " + userId;
	}
	
	@RequestMapping("/{id}/invoices")
	public String displayUserInvoices(@PathVariable("id") int userId,
			@RequestParam(value="date", required=false) Date dateOrNull) {
		return "Invoice found for user: " + userId + " - on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayStringJson() {
		return Arrays.asList(new Product(1, "shoes", 40.99),
				new Product(2, "books", 40.99),
				new Product(3, "bag", 40.99));
	}
}
