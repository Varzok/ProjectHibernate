package com.nttdata.dao;

import java.util.List;

import com.nttdata.persistencia.Contract;

/**
 * 
 * Bootcamp NTTData
 * 
 * Interfaz DAO tabla Contract
 * 
 * @author Salva Castillo
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Busca los contratos por id del cliente
	 * 
	 * @param id
	 * @return List<contract>
	 */
	public List<Contract> findByIdCustomer(Long id);
}
