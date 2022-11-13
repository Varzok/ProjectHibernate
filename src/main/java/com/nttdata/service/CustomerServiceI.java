package com.nttdata.service;

import java.util.List;

import com.nttdata.persistencia.Customer;

public interface CustomerServiceI {
	
	public void insertCustomer(final Customer newCustomer);

	public List<Customer> searchAll();

	public Customer searchById(final int i);

	public void deleteCustomer(final Customer deletedCustomer);
	
	public void updateCustomer(final Customer updatedCustomer);
	
	public List<Customer> searchByNameAndLastName(final String name, final String firstFamilyName, final String secondFamilyName);

	


	
	

}
