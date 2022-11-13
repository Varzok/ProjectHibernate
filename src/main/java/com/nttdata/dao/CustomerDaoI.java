package com.nttdata.dao;


import java.util.List;

import com.nttdata.persistencia.Customer;

public interface CustomerDaoI extends CommonDaoI<Customer> {

	public List<Customer> findByNameAndFamilyName(final String name, final String firstFamilyName, final String secondFamilyName);
}
