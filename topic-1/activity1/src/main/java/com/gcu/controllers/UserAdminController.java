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
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.data.UsersRepository;
import com.gcu.models.UserEntity;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // GET /admin/users - Display list of users
    @GetMapping("")
    public String showAdminPanel(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "admin";
    }

    // GET /admin/users/edit/{id} - Edit user role and enabled status
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        UserEntity user = usersRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "editUser";
    }

    // POST /admin/users/edit - Submit user edit
    @PostMapping("/edit")
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
        return "redirect:/admin/users";
    }

    // GET /admin/users/delete/{id} - Confirm delete
    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        UserEntity user = usersRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "confirmDelete";
    }

    // POST /admin/users/delete - Submit delete
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id, Principal principal) {
        UserEntity user = usersRepository.findById(id).orElse(null);
        // Prevent admin from deleting themselves
        if (user != null && user.getUsername().equals(principal.getName())) {
            return "redirect:/admin/users";
        }
        usersRepository.deleteById(id);
        return "redirect:/admin/users";
    }
}
