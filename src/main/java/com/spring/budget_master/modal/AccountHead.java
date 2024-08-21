package com.spring.budget_master.modal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AccountHead {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // e.g., Income, Expense
    private String description;
    private String status; // e.g., Active, Inactive
    private String classification; // e.g., Income, Expense

    @OneToMany(mappedBy = "accountHead")
    @JsonBackReference
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public List<Account> getAccountLists() {
		return accountLists;
	}

	public void setAccountLists(List<Account> accountLists) {
		this.accountLists = accountLists;
	}

	@Override
	public String toString() {
		return "AccountHead [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", classification=" + classification + ", accountLists=" + accountLists + "]";
	}

	
    
}
