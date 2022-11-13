package com.nttdata.service;

import java.util.List;

import com.nttdata.persistencia.Customer;

/**
 * 
 * Bootcamp NTTData
 * 
 * Interfaz Servicio Cliente
 * 
 * @author Salva Castillo
 *
 */
public interface CustomerServiceI {
	
	/**
	 * Inserta nuevo cliente
	 * 
	 * @param newCustomer
	 */
	public void insertCustomer(final Customer newCustomer);

	/**
	 * Recupera todos los clientes
	 * 
	 * @return List<clientes>
	 */
	public List<Customer> searchAll();
	
	/**
	 * Recupera cliente por identificador
	 * 
	 * @param i
	 * 
	 * @return cliente
	 */
	public Customer searchById(final int i);
	
	/**
	 * Elimina cliente
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final Customer deletedCustomer);
	
	/**
	 * Actualiza cliente
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final Customer updatedCustomer);
	
	/**
	 * 
	 * @param name
	 * @param firstFamilyName
	 * @param secondFamilyName
	 * @return List<clientes>
	 */
	public List<Customer> searchByNameAndLastName(final String name, final String firstFamilyName, final String secondFamilyName);

	


	
	

}
