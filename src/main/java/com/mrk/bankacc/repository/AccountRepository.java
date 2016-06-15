package com.mrk.bankacc.repository;

import org.springframework.dao.DataAccessException;
import com.mrk.bankacc.model.Account;

public interface AccountRepository {
	
	void save(Account account) throws DataAccessException;
	

}
