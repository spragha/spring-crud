package com.spragha.bankacc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spragha.bankacc.model.Account;
import com.spragha.bankacc.model.Customer;
import com.spragha.bankacc.repository.AccountRepository;
import com.spragha.bankacc.repository.CustomerRepository;

@Service
public class BankServiceImpl implements BankService {
	
	private CustomerRepository customerRepository;
	private AccountRepository accountRepository;
	
    @Autowired
    public BankServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }	

    @Override
    @Transactional(readOnly = true)
    public Customer findCustomerById(int id) throws DataAccessException {
        return customerRepository.findById(id);
    }
    
    @Override
    @Transactional
    public void saveCustomer(Customer customer) throws DataAccessException {
    	customerRepository.save(customer);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Collection<Customer> findCustomerByLastName(String lastName) throws DataAccessException {
        return customerRepository.findByLastName(lastName);
    }
    
    @Override
    @Transactional
    public void saveAccount(Account account) throws DataAccessException {
    	accountRepository.save(account);
    }
    
    
}
