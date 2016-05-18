package com.spragha.bankacc.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.spragha.bankacc.model.Customer;
@Repository
public class CustomerRepository {
	
	@PersistenceContext
    private EntityManager em;
	
	public void save(Customer customer) {
    	if (customer.getId() == null) {
    		this.em.persist(customer);     		
    	}
    	else {
    		this.em.merge(customer);    
    	}

    }

}
