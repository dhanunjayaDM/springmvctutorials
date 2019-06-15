package com.mhi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mhi.model.Customer;

@Repository
public class CustomerDAO 
{
	private static List<Customer> list=null;
	static {
		list=new ArrayList<Customer>();
		list.add(new Customer("asif","asif@gmail.com",29,"india"));
		list.add(new Customer("dhana","dhana@gmail.com",25, "india"));
		list.add(new Customer("chinna","chinna@gmail.com",27, "india"));
		
	}
	public  List<Customer> getCustomerList(){
		return list;
	}
	public void addCustomer(Customer customer) {
		list.add(customer);
		
	}

}
