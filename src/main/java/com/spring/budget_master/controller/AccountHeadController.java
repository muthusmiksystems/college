package com.spring.budget_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.budget_master.modal.AccountHead;
import com.spring.budget_master.service.AccountHeadService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/dashboard")
public class AccountHeadController {
    @Autowired
    private AccountHeadService accountHeadService;

    @GetMapping("/account-heads")
    public String listAccountHeads(Model model,HttpSession session) {
    	System.out.println("hai");
    	String username = (String) session.getAttribute("username");
    	 System.out.println("Retrieved username from session: " + username); 
    	 model.addAttribute("username", username);
    	 model.addAttribute("accountHeads", accountHeadService.findAll());
        return "account-head-lists";
    }
   
   
    @GetMapping("/account-heads/new")
    public String createAccountHeadForm(Model model,HttpSession session) {
     String username = (String) session.getAttribute("username");
   	 System.out.println("Retrieved username from session: " + username); 
   	 model.addAttribute("username", username);
        model.addAttribute("accountHead", new AccountHead());
        model.addAttribute("classifications", new String[]{"Income", "Expense"});
        return "account-head-form";
    }

    @PostMapping("/account-heads")
    public String saveAccountHead(@ModelAttribute AccountHead accountHead) {
        accountHeadService.save(accountHead);
        return "redirect:/admin/dashboard/account-heads";
    }

    @GetMapping("/account-heads/delete/{id}")
    public String deleteAccountHead(@PathVariable Long id) {
        accountHeadService.delete(id);
        return "redirect:/admin/dashboard/account-heads";
    }
}
