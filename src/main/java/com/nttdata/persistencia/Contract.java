package com.nttdata.persistencia;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

/**
 * 
 * Bootcamp NTTData
 * 
 * Entidad de tabla Contract
 * 
 * @author Salva Castillo
 *
 */
@Entity
@Table(name = "Contract")
public class Contract extends AbstractEntity implements Serializable{

	/**Serial Version*/
	private static final long serialVersionUID = 1L;

	/**Identificador*/
	private int idContract;
	
	/**Fecha de vigencia*/
	private Date dateIn;
	
	/**Fecha de caducidad*/
	private Date dateOut;
	
	/**Precio mensual*/
	private Double monthlyPrice;
	
	/**Id del cliente*/
	private Customer customer;
	
	/**
	 * Getter
	 * @return idContract
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contract")
	public int getIdContract() {
		return idContract;
	}

	/**
	 * Setter
	 * @param id
	 */
	public void setIdContract(int id) {
		this.idContract = id;
	}
	
	/**
	 * Getter
	 * @return dateIn
	 */
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDateIn() {
		return dateIn;
	}

	/**
	 * Setter
	 * @param dateIn
	 */
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	/**
	 * Getter
	 * @return dateOut
	 */
	@Column
	@Temporal(TemporalType.DATE)
	public Date getDateOut() {
		return dateOut;
	}

	/**
	 * Setter
	 * @param dateOut
	 */
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	/**
	 * Getter
	 * @return monthyPrice
	 */
	@Column
	@Digits(fraction = 2, integer = 5)
	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * Setter
	 * @param monthlyPrice
	 */
	public void setMonthlyPrice(Double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * Getter
	 * @return customer
	 */
	@ManyToOne
	@JoinColumn(name = "customer")
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Setter
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * String con información del objeto
	 */
	@Override
	public String toString() {
		return "Contract [idContract=" + idContract + ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", monthlyPrice="
				+ monthlyPrice + ", customer=" + customer + "]";
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idContract;
	}

	@Override
	public void setId(int id) {
		this.idContract = id;
		
	}

}