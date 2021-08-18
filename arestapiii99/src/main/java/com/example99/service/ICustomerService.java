package com.example99.service;

import java.util.List;

import com.example99.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
}
