package com.spring.budget_master.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.budget_master.modal.Account;
import com.spring.budget_master.repository.AccountRepository;

@Service
public class AccountService {
	 @Autowired
	    private AccountRepository accountRepository;

	    public List<Account> findAll() {
	        return accountRepository.findAll();
	    }

	    public Account save(Account account) {
	        return accountRepository.save(account);
	    }

	    public void delete(Long id) {
	        accountRepository.deleteById(id);
	    }
}
