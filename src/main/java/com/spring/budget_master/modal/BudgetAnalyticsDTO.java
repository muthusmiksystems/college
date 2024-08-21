package com.spring.budget_master.modal;

public class BudgetAnalyticsDTO {
	private String accountHeadName;
    private double totalIncome;
    private double totalExpense;
    private double budgetDifference;

    public BudgetAnalyticsDTO(String accountHeadName, double totalIncome, double totalExpense, double budgetDifference) {
        this.accountHeadName = accountHeadName;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.budgetDifference = budgetDifference;
    }

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public double getBudgetDifference() {
		return budgetDifference;
	}

	public void setBudgetDifference(double budgetDifference) {
		this.budgetDifference = budgetDifference;
	}

}
