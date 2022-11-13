package com.nttdata.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.persistencia.AbstractEntity;

/**
 * 
 * Bootcamp NTTData
 * 
 * DAO genérico
 * 
 * @author Salva Castillo
 * 
 */
@Repository
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	
	/**Tipo de clase*/
	private Class<T> entityClass;
	
	/**Manejador de entidades */
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	
	@Override
	@Transactional
	public T findById(int id) {
		//Obtencion de sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Busqueda por identificador.
		T entity = currentSession.find(entityClass, id);
		//Cierre de sesión
		currentSession.close();
				
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> findAll() {
		//Obtencion de sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Busqueda de todos los registros.
		List<T> list = currentSession.createQuery("FROM " + this.entityClass.getName()).list();
		//Cierre de sesión
		currentSession.close();
		
		return list;
	}

	@Override
	@Transactional
	public void create(T entity) {
		//Obtencion de sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Insercción
		currentSession.save(entity);
		//Cierre de sesión
		currentSession.close();
	}

	@Override
	@Transactional
	public T update(T entity) {
		//Obtencion de sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Modifica registro
		currentSession.update(entity);
		//Cierre de sesión
		currentSession.close();
		return entity;
	}

	@Override
	@Transactional
	public void delete(T entity) {
		//Obtencion de sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Elimina registro
		currentSession.delete(entity);
		//Cierre de sesión
		currentSession.close();
	}
	
	/**@param entityClass*/
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/** @return entityClass*/
	public Class<T> getEntityClass() {
		return entityClass;
	}
	
}
