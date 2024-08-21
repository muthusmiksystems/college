package com.spring.budget_master.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.budget_master.modal.BudgetAnalyticsDTO;
import com.spring.budget_master.service.BudgetAnalyticsService;
@Controller
@RequestMapping("/admin/dashboard")
public class BudgetAnalyticsController {
	@Autowired
    private BudgetAnalyticsService budgetAnalyticsService;

    @GetMapping("/budget-analytics")
    public String viewBudgetAnalytics(Model model) {
        List<BudgetAnalyticsDTO> analytics = budgetAnalyticsService.calculateBudgetAnalytics();
        model.addAttribute("analytics", analytics);
        return "budget-analytics";
    }
}
