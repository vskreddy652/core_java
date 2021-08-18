package com.example99.arestapiii99.service;

import java.util.List;

import com.example99.arestapiii99.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int id);
}
