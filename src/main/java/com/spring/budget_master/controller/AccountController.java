package com.spring.budget_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.budget_master.modal.Account;
import com.spring.budget_master.service.AccountHeadService;
import com.spring.budget_master.service.AccountService;
import com.spring.budget_master.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/dashboard")
public class AccountController {
	@Autowired
    private AccountService accountService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AccountHeadService accountHeadService;
	
    @GetMapping("/accounts")
    public String listAccounts(Model model, HttpSession session) {
    	System.out.println("hai2222");
    	String username = (String) session.getAttribute("username");
    	 System.out.println("Retrieved username from session: " + username); // Debug log
    	 model.addAttribute("username", username);
        model.addAttribute("accounts", accountService.findAll());
        System.out.println("accounts"+accountService.findAll());
        return "account-list";
    }

    @GetMapping("/accounts/new")
    public String createAccountForm(Model model,HttpSession session) {
    	String username = (String) session.getAttribute("username");
   	 	System.out.println("Retrieved username from session: " + username); // Debug log
   	 	model.addAttribute("username", username);
   	 	model.addAttribute("account", new Account());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("accountHeads", accountHeadService.findAll());
        return "account-form";
    }

    @PostMapping("/accounts")
    public String saveAccount(@ModelAttribute Account account) {
        accountService.save(account);
        System.out.println("account"+account);
        return "redirect:/admin/dashboard/accounts";
    }

    @GetMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return "redirect:/admin/dashboard/accounts";
    }
}
