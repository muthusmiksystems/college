package com.spring.budget_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.budget_master.modal.User;
import com.spring.budget_master.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/user/login")
    public String loginUser(@ModelAttribute User user, Model model, HttpSession session) {
        try {
            User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
            session.setAttribute("username", loggedInUser.getUsername()); // Store username in session
            System.out.println("Logged in username: " + loggedInUser.getUsername()); // Debug log
            return "redirect:/admin/dashboard";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }


    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        System.out.println("Retrieved username from session: " + username); // Debug log
        model.addAttribute("username", username);
        return "admin-dashboard";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/user/login";
    }
}
