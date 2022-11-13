package com.nttdata.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nttdata.persistencia.Customer;

/**
 * 
 * Bootcamp NTTData
 * 
 * DAO tabla Clientes
 * 
 * @author Salva Castillo
 *
 */
@Repository
public class CustomerDaoImpl extends CommonDaoImpl <Customer> implements CustomerDaoI {

	/** Manejador de entidades*/
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public CustomerDaoImpl() {
		setEntityClass((Class<Customer>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	public List<Customer> findByNameAndFamilyName(final String name, final String firstFamilyName, final String secondFamilyName){
		
		// Obtencion de sesión
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Busqueda por nombre, primer apellido y segundo apellido.
		@SuppressWarnings("unchecked")
		List<Customer> customer = currentSession.createQuery("FROM Customer customer WHERE name='" + name + "'AND first_family_name='" + firstFamilyName + "' AND second_family_name='" + secondFamilyName +"'").list();
		
		// Cierre de sesión
		currentSession.close();
		
		return customer;
	}

}
