package com.nttdata.dao;

import java.util.List;

/**
 * 
 * Bootcamp NTTData
 * 
 * Interfaz DAO genérico
 * 
 * @author Salva Castillo
 *
 */

public interface CommonDaoI <T>{
	
	/**
	 * Busca por identificador en BBDD
	 * 
	 * @param id 
	 */
	T findById(int id);
	
	/**
	 * Busca todos los registros  en BBDD
	 * 
	 * @return List<todosLosRegistros>
	 */
	List<T> findAll();
	
	/**
	 * Crea registro en BBDD
	 * 
	 * @param entity
	 */
	void create (T entity);
	
	/**
	 * Actualiza registro en BBDD
	 * 
	 * @param entity
	 * @return objeto del registro
	 */
	T update (T entity);
	
	/**
	 * Elimina registro en BBDD
	 * 
	 * @param entity
	 */
	void delete (T entity);
	

}
