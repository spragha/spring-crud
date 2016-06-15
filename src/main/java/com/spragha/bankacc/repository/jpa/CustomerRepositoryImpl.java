package com.spragha.bankacc.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.spragha.bankacc.model.Customer;
import com.spragha.bankacc.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public Collection<Customer> findByLastName(String lastName) {
        // using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT DISTINCT customer FROM Customer customer left join fetch customer.accounts WHERE customer.lastName LIKE :lastName");
        query.setParameter("lastName", lastName + "%");
        return query.getResultList();
    }
    
    @Override
    public Customer findById(int id) {
        // using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT customer FROM Customer customer left join fetch customer.accounts WHERE customer.id =:id");
        query.setParameter("id", id);
        return (Customer) query.getSingleResult();
    }


    @Override
    public void save(Customer customer) {
    	if (customer.getId() == null) {
    		this.em.persist(customer);     		
    	}
    	else {
    		this.em.merge(customer);    
    	}

    }
    
    
}
