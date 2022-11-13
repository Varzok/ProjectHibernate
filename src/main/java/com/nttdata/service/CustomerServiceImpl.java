package com.nttdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.CustomerDaoI;
import com.nttdata.persistencia.Customer;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	@Autowired
	private CustomerDaoI customerDao;

	@Override
	public void insertCustomer(Customer newCustomer) {
		if(newCustomer != null) {
			customerDao.create(newCustomer);
		}
	}

	@Override
	public List<Customer> searchAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerDao.findAll();
		
		return customers;
	}
	
	@Override
	public List<Customer> searchByNameAndLastName(String name,String firstFamilyName, String secondFamilyName) {

		List<Customer> customers = new ArrayList<Customer>();
		customers = customerDao.findByNameAndFamilyName(name, firstFamilyName, secondFamilyName);
		return customers;
		
	}

	@Override
	public Customer searchById(int IdCustomer) {
		return customerDao.findById(IdCustomer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

}
