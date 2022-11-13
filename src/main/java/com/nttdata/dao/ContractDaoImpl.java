package com.nttdata.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.persistencia.Contract;

/**
 * 
 * Bootcamp NTTData
 * 
 * DAO tabla Contract
 * 
 * @author Salva Castillo
 *
 */
@Repository
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI{

	/** Manejador de entidades*/
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public ContractDaoImpl() {
		setEntityClass((Class<Contract>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	@Transactional
	public List<Contract> findByIdCustomer(Long idCustomer) {
		
		// Obtencion de sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Busqueda por identificador de cliente
		@SuppressWarnings("unchecked")
		List<Contract> contract = currentSession.createQuery("FROM Contract WHERE Customer.id_customer=" + idCustomer ).list();
		
		// Cierre de sesión
		currentSession.close();
		
		return contract;
	}

}
