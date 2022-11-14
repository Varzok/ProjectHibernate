package com.nttdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.CustomerDaoI;
import com.nttdata.persistencia.Customer;

/**
 * 
 * Bootcamp NTTData
 * 
 * Implementación servicio cliente
 * 
 * @author Salva Castillo
 *
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI {
	
	/**DAO customer*/
	@Autowired
	private CustomerDaoI customerDao;
	
	/**Inserta cliente*/
	@Override
	public void insertCustomer(Customer newCustomer) {
		if(newCustomer != null) {
			customerDao.create(newCustomer);
		}
	}

	/**busca todos los clientes*/
	@Override
	public List<Customer> searchAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerDao.findAll();
		
		return customers;
	}
	
	/**busca cliente por nombre y apellidos*/
	@Override
	public List<Customer> searchByNameAndLastName(String name,String firstFamilyName, String secondFamilyName) {

		List<Customer> customers = new ArrayList<Customer>();
		customers = customerDao.findByNameAndFamilyName(name, firstFamilyName, secondFamilyName);
		return customers;
		
	}
	
	/**busca cliente por nombre y apellidos con Criteria*/
	@Override
	public List<Customer> criteriaSearchByNameAndLastName(String name,String firstFamilyName, String secondFamilyName) {

		List<Customer> customers = new ArrayList<Customer>();
		customers = customerDao.criteriaFindByNameAndFamilyName(name, firstFamilyName, secondFamilyName);
		return customers;
		
	}

	/**busca cliente por identificador*/
	@Override
	public Customer searchById(int IdCustomer) {
		return customerDao.findById(IdCustomer);
	}

	/**elimina cliente*/
	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.delete(customer);
	}

	/**actualiza cliente*/
	@Override
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

}