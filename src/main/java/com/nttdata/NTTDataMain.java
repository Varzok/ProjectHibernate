package com.nttdata;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.persistencia.Customer;
import com.nttdata.service.CustomerServiceI;

@SpringBootApplication
public class NTTDataMain implements CommandLineRunner{
	
	@Autowired
	private CustomerServiceI customerService;

	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		

		
		
		final Customer customer1 = new Customer();
		customer1.setName("María");
		customer1.setFirstFamilyName("Barrales");
		customer1.setSecondFamilyName("Morillo");
		customer1.setIdDocument("12312312N");
		
		final Customer customer2 = new Customer();
		customer2.setName("Juan");
		customer2.setFirstFamilyName("Bosques");
		customer2.setSecondFamilyName("Pallares");
		customer2.setIdDocument("12345654T");
		
		
		
		customerService.insertCustomer(customer1);
		customerService.insertCustomer(customer2);
		
		System.out.println("Lista de Clientes");
		
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = customerService.searchAll();
		System.out.println("Lista de Clientes");
		for(Customer customer: customerList) {
			String custom = customer.toString();
			System.out.println(custom);
		}
		int idLook = 3;
		if(customerService.searchById(idLook) != null) {
		System.out.println(customerService.searchById(idLook).toString());
		}else {
			System.out.println("Cliente con id " + idLook + " no encontrado" );
		}
		
		customerList = customerService.searchByNameAndLastName("Juan","Bosques","Pallares");
		System.out.println("¿Está Juan?");
		for(Customer customer: customerList) {
			String custom = customer.toString();
			System.out.println(custom);
		}
		
		customerList = customerService.searchByNameAndLastName("Miri", "Vargas", "Palomino");

		for (Customer customer : customerList) {
			String custom = customer.toString();
			System.out.println(custom);
		}

	}

}
