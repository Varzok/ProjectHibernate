package com.nttdata.dao;

import java.util.List;

public interface CommonDaoI <T>{
	
	T findById(int id);
	List<T> findAll();
	void create (T entity);
	T update (T entity);
	void delete (T entity);
	

}
