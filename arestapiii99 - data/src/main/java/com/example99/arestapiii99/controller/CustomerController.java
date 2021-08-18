package com.example99.arestapiii99.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example99.arestapiii99.entity.Customer;
import com.example99.arestapiii99.service.ICustomerService;

@CrossOrigin(value="xyz.com")
@RestController
public class CustomerController {
	@Autowired
	ICustomerService cservice;
	
	//GET - read, PUT, POST - create, DELETE
	
	@PostMapping("/createcustomer")
	public Customer createCustomer(@RequestBody Customer cust) {
		Customer ncust = cservice.addCustomer(cust);
		return ncust;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		List<Customer> lcust = cservice.getAllCustomers();
		return lcust;		
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id") int cid) {
		Customer cust = cservice.getCustomer(cid);
		return cust;
	}
}
