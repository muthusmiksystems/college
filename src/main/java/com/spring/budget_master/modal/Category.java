package com.spring.budget_master.modal;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // e.g., Food, Stationary Item

    @OneToMany(mappedBy = "category")
    private List<Account> accountLists;

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

	public List<Account> getAccountLists() {
		return accountLists;
	}

	public void setAccountLists(List<Account> accountLists) {
		this.accountLists = accountLists;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", accountLists=" + accountLists + "]";
	} 
    
}
