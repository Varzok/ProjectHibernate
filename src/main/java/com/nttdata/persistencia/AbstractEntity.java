package com.nttdata.persistencia;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractEntity() {
		// TODO Auto-generated constructor stub
	}

	public  abstract int getId();
	

	public abstract void setId(int id);

}
