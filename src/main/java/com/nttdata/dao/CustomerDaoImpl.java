package com.nttdata.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	@Override
	public List<Customer> criteriaFindByNameAndFamilyName(String name, String firstFamilyName, String secondFamilyName) {
		
		//Consulta
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		
		//Where
		Predicate pr1 = cb.equal(root.get("name"), name);
		Predicate pr2 = cb.equal(root.get("firstFamilyName"), firstFamilyName);
		Predicate pr3 = cb.equal(root.get("secondFamilyName"), secondFamilyName);
		
		//Consulta
		cq.select(root).where(cb.and(pr1, pr2, pr3));
		 
		//Ejecución de consulta
		List<Customer> listCustomer = entityManager.createQuery(cq).getResultList();
		
		return listCustomer;
	}

}