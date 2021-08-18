package com.example99.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example99.entity.Customer;

@Repository
public class CustomerRepo {
	private List<Customer> lcustomer;
	
	public CustomerRepo(){
		lcustomer = new ArrayList<Customer>();
	}
	
	public Customer createCustomer(Customer customer) {
		lcustomer.add(customer);
		
		return customer;
	}
	
	public List<Customer> getCustomers() {
		return lcustomer;
	}
}
