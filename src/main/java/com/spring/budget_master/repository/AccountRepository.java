package com.spring.budget_master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.budget_master.modal.Account;
import com.spring.budget_master.modal.AccountHead;

public interface AccountRepository extends JpaRepository<Account, Long> {
	 List<Account> findByAccountHead(AccountHead accountHead);
}
