package com.spragha.bankacc.repository;

import org.springframework.dao.DataAccessException;
import com.spragha.bankacc.model.Account;

public interface AccountRepository {
	
	void save(Account account) throws DataAccessException;
	

}
