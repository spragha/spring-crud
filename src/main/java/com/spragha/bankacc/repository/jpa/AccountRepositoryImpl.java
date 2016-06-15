package com.spragha.bankacc.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.spragha.bankacc.repository.AccountRepository;
import com.spragha.bankacc.model.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Account account) {
    	if (account.getAccNumber() == null) {
    		this.em.persist(account);     		
    	}
    	else {
    		this.em.merge(account);    
    	}
    }

}
