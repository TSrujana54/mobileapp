package com.mobileapp.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileapp.customer.dao.CustomerDAO;
import com.mobileapp.customer.model.Customer;
@Service
public class CustomerService {
	@Autowired
	CustomerDAO dao;
	boolean flag = false;

	public boolean addCustomer(Customer customer) {
		Customer customerDB = dao.save(customer);
		if(customerDB!=null)
			flag = true;
		return flag;
	}

	public boolean validate(Customer customer) {
		Optional<Customer> optCustomer = dao.findById(customer.getCustomerName());
		if(optCustomer.isPresent())
			flag = true;
		return flag;
	}

}
