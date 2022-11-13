package com.nttdata.dao;


import java.util.List;

import com.nttdata.persistencia.Customer;

/**
 * 
 * Bootcamp NTTData
 * 
 * Interfaz DAO tabla Cliente
 * 
 * @author Salva Castillo
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer> {

	/**
	 * Obtiene clientes por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstFamilyName
	 * @param secondFamilyName
	 * @return List<todosLosClientes>
	 */
	public List<Customer> findByNameAndFamilyName(final String name, final String firstFamilyName, final String secondFamilyName);
}