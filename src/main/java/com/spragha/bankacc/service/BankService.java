package com.spragha.bankacc.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.spragha.bankacc.model.Account;
import com.spragha.bankacc.model.Customer;

public interface BankService {

	public Customer findCustomerById(int id) throws DataAccessException;
	
	public void saveCustomer(Customer customer) throws DataAccessException;
	
	Collection<Customer> findCustomerByLastName(String lastName) throws DataAccessException;
	
	public void saveAccount(Account account) throws DataAccessException;
	
}
