package com.example99.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example99.entity.Customer;
import com.example99.repository.CustomerRepo;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerRepo crepo;
	
	public Customer addCustomer(Customer customer) {
		Customer cust = crepo.createCustomer(customer);
		return cust;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> lcust = crepo.getCustomers();
		return lcust;
	}

}
