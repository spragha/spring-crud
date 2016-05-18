package com.spragha.bankacc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spragha.bankacc.model.Customer;
import com.spragha.bankacc.repository.CustomerRepository;
@Service
public class BankingService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public BankingService(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	@Transactional
    public void saveCustomer(Customer customer) throws DataAccessException {
		customerRepository.save(customer);
    }

}
