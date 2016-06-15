package com.mrk.bankacc.repository;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import com.mrk.bankacc.model.Customer;

public interface CustomerRepository {

    Collection<Customer> findByLastName(String lastName) throws DataAccessException;

    Customer findById(int id) throws DataAccessException;

    void save(Customer customer) throws DataAccessException;
}
