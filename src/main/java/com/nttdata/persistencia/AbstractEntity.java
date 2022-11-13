package com.nttdata.persistencia;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 
 * Bootcamp NTTData
 * 
 * Entidad abstracta
 * 
 * @author Salva Castillo
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	/**Serial version*/
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @return int
	 */
	public  abstract int getId();
	
	/**
	 * 
	 * @param id
	 */
	public abstract void setId(int id);

}