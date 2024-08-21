package com.spring.budget_master.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.budget_master.modal.Account;
import com.spring.budget_master.modal.AccountHead;
import com.spring.budget_master.modal.BudgetAnalyticsDTO;
import com.spring.budget_master.repository.AccountHeadRepository;
import com.spring.budget_master.repository.AccountRepository;

@Service
public class BudgetAnalyticsService {
	@Autowired
    private AccountHeadRepository accountHeadRepository;

    @Autowired
    private AccountRepository accountListRepository;

    public List<BudgetAnalyticsDTO> calculateBudgetAnalytics() {
        List<AccountHead> accountHeads = accountHeadRepository.findAll();
        System.out.printf("accountListsxxxxxx",accountHeads);
        return accountHeads.stream().map(accountHead -> {
            List<Account> accountLists = accountListRepository.findByAccountHead(accountHead);
            System.out.printf("accountLists",accountLists);
            double totalIncome = accountLists.stream()
                    .filter(accountList -> accountList.getType().equalsIgnoreCase("Income"))
                    .mapToDouble(Account::getBalance)
                    .sum();

            double totalExpense = accountLists.stream()
                    .filter(accountList -> accountList.getType().equalsIgnoreCase("Expense"))
                    .mapToDouble(Account::getBalance)
                    .sum();

            double budgetDifference = totalIncome - totalExpense;

            return new BudgetAnalyticsDTO(accountHead.getName(), totalIncome, totalExpense, budgetDifference);
        }).collect(Collectors.toList());
    }
}
