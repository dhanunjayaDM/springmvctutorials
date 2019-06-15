package com.mhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhi.dao.CustomerDAO;
import com.mhi.model.Customer;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerDAO customerDAo;
	public List<Customer> getCustomerList()
	{
		return customerDAo.getCustomerList();
		
	}
	
	public void createUser(Customer customer) {
		customerDAo.addCustomer(customer);
	}

}
