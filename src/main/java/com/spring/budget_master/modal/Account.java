package com.spring.budget_master.modal;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // e.g., Purchase Stationary Item, AmountDebited
    private String type; // e.g., Income, Expense
    private double balance;
    private double amountDebited;
    private String status;

    @ManyToOne
    private Category category;

    @ManyToOne
    @JsonBackReference
    private AccountHead accountHead;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmountDebited() {
		return amountDebited;
	}

	public void setAmountDebited(double amountDebited) {
		this.amountDebited = amountDebited;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public AccountHead getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(AccountHead accountHead) {
		this.accountHead = accountHead;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", type=" + type + ", balance=" + balance + ", amountDebited="
				+ amountDebited + ", status=" + status + ", category=" + category + ", accountHead=" + accountHead
				+ "]";
	}

	
    
    
}
