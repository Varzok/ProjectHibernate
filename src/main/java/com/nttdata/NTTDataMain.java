package com.nttdata;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.persistencia.Customer;
import com.nttdata.service.CustomerServiceI;

/**
 * 
 * Bootcamp NTTData
 * 
 * Clase para pruebas de tarea
 * 
 * @author Salva Castillo
 *
 */
@SpringBootApplication
public class NTTDataMain implements CommandLineRunner{
	
	@Autowired
	private CustomerServiceI customerService;

	/**
	 * Método main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}
	
	/**
	 * Método run
	 */
	public void run(String... args) throws Exception {
		
		//Creación de objeto customer1
		final Customer customer1 = new Customer();
		customer1.setName("María");
		customer1.setFirstFamilyName("Barrales");
		customer1.setSecondFamilyName("Morillo");
		customer1.setIdDocument("12312312N");
		
		//Creación  de objeto customer2
		final Customer customer2 = new Customer();
		customer2.setName("Juan");
		customer2.setFirstFamilyName("Bosques");
		customer2.setSecondFamilyName("Pallares");
		customer2.setIdDocument("12345654T");

		// Creación de objeto customer2
		final Customer customer3 = new Customer();
		customer3.setName("Ana");
		customer3.setFirstFamilyName("García");
		customer3.setSecondFamilyName("Torres");
		customer3.setIdDocument("21345654T");

		//Se añaden los dos objetos de tipo customer
		customerService.insertCustomer(customer1);
		customerService.insertCustomer(customer2);
		customerService.insertCustomer(customer3);
		
		//Consulta todos los registros de customer
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = customerService.searchAll();
		System.out.println("Lista de Clientes");
		for(Customer customer: customerList) {
			String custom = customer.toString();
			System.out.println(custom);
		}
		
		//Busqueda de un Cliente por identificador
		int idSearch1 = 1;
		if(customerService.searchById(idSearch1) != null) {
		System.out.println(customerService.searchById(idSearch1).toString());
		}else {
			System.out.println("Cliente con id " + idSearch1 + " no encontrado" );
		}
		
		//Busqueda de un Cliente por nombre y apellidos
		customerList = customerService.searchByNameAndLastName("Juan","Bosques","Pallares");
		for(Customer customer: customerList) {
			String custom = customer.toString();
			System.out.println(custom);
		}
		
		//Actualizar datos de un cliente
		customer2.setName("Juan Antonio");
		customerService.updateCustomer(customer2);
		
		// Busqueda de un Cliente por identificador
		int idSearch2 = 2;
		if (customerService.searchById(idSearch2) != null) {
			System.out.println(customerService.searchById(idSearch2).toString());
		} else {
			System.out.println("Cliente con id " + idSearch2 + " no encontrado");
		}
		

	}

}
