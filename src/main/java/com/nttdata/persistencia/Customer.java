package com.nttdata.persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer extends AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int idCustomer;
	
	
	private String name;
	
	
	private String firstFamilyName;
	
	
	private String secondFamilyName;
	
	
	private String idDocument;
	
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", firstFamilyName=" + firstFamilyName
				+ ", secondFamilyName=" + secondFamilyName + ", idDocument=" + idDocument + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_customer")
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "first_family_name", nullable = false)
	public String getFirstFamilyName() {
		return firstFamilyName;
	}
	public void setFirstFamilyName(String firstFamilyName) {
		this.firstFamilyName = firstFamilyName;
	}
	
	@Column(name = "second_family_name", nullable = false)
	public String getSecondFamilyName() {
		return secondFamilyName;
	}
	public void setSecondFamilyName(String secondFamilyName) {
		this.secondFamilyName = secondFamilyName;
	}
	
	@Column(name = "id_document", unique = true, nullable = false, length = 9)
	public String getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}
	
	@Override
	public int getId() {
		return this.idCustomer;
	}

	@Override
	public void setId(int id) {
		this.idCustomer = id;
	}
	
}
