package com.nttdata.service;

import java.util.List;

import com.nttdata.persistencia.Contract;

/**
 * 
 * Bootcamp NTTData
 * 
 * Interfaz Servicio Contract
 * 
 * @author Salva Castillo
 *
 */
public interface ContractServiceI {

	/**
	 * Inserta nuevo contrato
	 * 
	 * @param newContract
	 */
	public void insertContract(final Contract newContract);

	/**
	 * Recupera todos los contratos
	 * 
	 * @return List<contract>
	 */
	public List<Contract> searchAll();
	
	/**
	 * Recupera cliente por identificador
	 * 
	 * @param i
	 * 
	 * @return contrato
	 */
	public Contract searchById(final int i);
	
	/**
	 * Elimina contrato
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final Contract deletedContract);
	
	/**
	 * Actualiza contrato
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updatedContract);
	
	/**
	 * Busca los contratos del cliente por identificador
	 * 
	 * @param idCustomer
	 * @return List<contratos>
	 */
	public List<Contract> findByIdCustomer(Long idCustomer);
}
