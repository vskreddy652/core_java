package com.example99.arestapiii99.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example99.arestapiii99.CustomerRepo;
import com.example99.arestapiii99.entity.Customer;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerRepo crepo;
	
	public Customer addCustomer(Customer customer) {
		Customer cust = crepo.save(customer);
		return cust;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> lcust = crepo.findAll();
		return lcust;
	}

	public Customer getCustomer(int id) {
		Optional<Customer> cust = crepo.findById((long) id);
		
		return cust.get();
	}

}
