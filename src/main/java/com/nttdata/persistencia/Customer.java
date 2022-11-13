package com.nttdata.persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Bootcamp NTTData
 * 
 * Entidad de tabla Customer
 * 
 * @author Salva Castillo
 *
 */
@Entity
@Table(name = "Customer")
public class Customer extends AbstractEntity implements Serializable{
	
	/**Serial version*/
	private static final long serialVersionUID = 1L;
	
	/**Identificador único*/
	private int idCustomer;
	
	/**Nombre del cliente*/
	private String name;
	
	/**Primer apellido cliente*/
	private String firstFamilyName;
	
	/**Segundo apellido cliente*/
	private String secondFamilyName;
	
	/**Documento de identidad cliente*/
	private String idDocument;
	
	@OneToMany(mappedBy = "customer")
	private List<Contract> listContract;
	
	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", name=" + name + ", firstFamilyName=" + firstFamilyName
				+ ", secondFamilyName=" + secondFamilyName + ", idDocument=" + idDocument + "]";
	}
	
	/**
	 * Getter
	 * 
	 * @return idCustomer
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_customer")
	public int getIdCustomer() {
		return idCustomer;
	}
	
	/**
	 * Setter
	 * 
	 * @param idCustomer
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	/**
	 * Getter
	 * 
	 * @return name
	 */
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	/**
	 * Setter
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter
	 * 
	 * @return firstFamilyName
	 */
	@Column(name = "first_family_name", nullable = false)
	public String getFirstFamilyName() {
		return firstFamilyName;
	}
	
	/**
	 * Setter
	 * 
	 * @param firstFamilyName
	 */
	public void setFirstFamilyName(String firstFamilyName) {
		this.firstFamilyName = firstFamilyName;
	}
	
	/**
	 * Getter
	 * 
	 * @return secondFamilyName
	 */
	@Column(name = "second_family_name", nullable = false)
	public String getSecondFamilyName() {
		return secondFamilyName;
	}
	
	/**
	 * Setter
	 * 
	 * @param secondFamilyName
	 */
	public void setSecondFamilyName(String secondFamilyName) {
		this.secondFamilyName = secondFamilyName;
	}
	
	/**
	 * Getter
	 * 
	 * @return idDocument
	 */
	@Column(name = "id_document", unique = true, nullable = false, length = 9)
	public String getIdDocument() {
		return idDocument;
	}
	
	/**
	 * Setter
	 * 
	 * @param idDocument
	 */
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
