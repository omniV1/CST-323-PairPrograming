package com.gcu.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.UsersRepository;
import com.gcu.models.UserEntity;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public String showAdminPanel(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "admin";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        UserEntity user = usersRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute UserEntity user, Principal principal, Model model) {
        UserEntity existingUser = usersRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            // Prevent admin from demoting themselves
            boolean isSelf = existingUser.getUsername().equals(principal.getName());
            boolean isDemotion = existingUser.getRole().equals("ROLE_ADMIN") && !user.getRole().equals("ROLE_ADMIN");
            if (isSelf && isDemotion) {
                model.addAttribute("user", existingUser);
                model.addAttribute("error", "You cannot demote yourself");
                return "editUser";
            }
            existingUser.setUsername(user.getUsername());
            existingUser.setRole(user.getRole());
            existingUser.setEnabled(user.isEnabled());
            // Only update password if a new one is provided
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            usersRepository.save(existingUser);
        }
        return "redirect:/admin";
    }

    @GetMapping("/confirmDelete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        UserEntity user = usersRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "confirmDelete";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id, Principal principal) {
        UserEntity user = usersRepository.findById(id).orElse(null);
        // Prevent admin from deleting themselves
        if (user != null && user.getUsername().equals(principal.getName())) {
            return "redirect:/admin";
        }
        usersRepository.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/toggleUser/{id}")
    public String toggleUserStatus(@PathVariable("id") int id) {
        UserEntity user = usersRepository.findById(id).orElse(null);
        if (user != null) {
            user.setEnabled(!user.isEnabled());
            usersRepository.save(user);
        }
        return "redirect:/admin";
    }
}