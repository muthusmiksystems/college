package com.spring.budget_master.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.budget_master.modal.AccountHead;
import com.spring.budget_master.repository.AccountHeadRepository;

@Service
public class AccountHeadService {
	@Autowired
	private AccountHeadRepository accountHeadRepository;
	public List<AccountHead> findAll() {
        return accountHeadRepository.findAll();
    }

    public AccountHead save(AccountHead accountHead) {
        return accountHeadRepository.save(accountHead);
    }

    public void delete(Long id) {
        accountHeadRepository.deleteById(id);
    }
}
