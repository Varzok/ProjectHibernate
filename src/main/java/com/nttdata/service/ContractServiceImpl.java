package com.nttdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.ContractDaoI;
import com.nttdata.persistencia.Contract;

/**
 * 
 * Bootcamp NTTData
 * 
 * Implementación servicio contrato
 * 
 * @author Salva Castillo
 *
 */
@Service
public class ContractServiceImpl implements ContractServiceI {

	/**DAO contract*/
	@Autowired
	private ContractDaoI contractDao;
	
	/**Inserta contrato*/
	@Override
	public void insertContract(Contract newContract) {
		if(newContract != null) {
			contractDao.create(newContract);
		}
	}

	/**busca todos los contratos*/
	@Override
	public List<Contract> searchAll() {
		
		List<Contract> contract = new ArrayList<Contract>();
		contract = contractDao.findAll();
		
		return contract;
	}

	/**busca contrato por identificador*/
	@Override
	public Contract searchById(int idContract) {
		
		return contractDao.findById(idContract);
	}
	
	/**elimina contrato*/
	@Override
	public void deleteContract(Contract deletedContract) {
		contractDao.delete(deletedContract);

	}
	
	/**actualiza contrato*/
	@Override
	public void updateContract(Contract updatedContract) {
		contractDao.update(updatedContract);
	}
	
	/**busca contratos de cliente*/
	@Override
	public List<Contract> findByIdCustomer(Long idCustomer){
		List<Contract> contracts = new ArrayList<Contract>();
		contracts = contractDao.findByIdCustomer(idCustomer);
		return contracts;
	}

}