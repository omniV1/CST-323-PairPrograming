package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.UsersRepository;
import com.gcu.models.UserEntity;
import com.gcu.models.UserModel;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/processRegister")
    public String processRegister(@ModelAttribute UserModel user, Model model) {
        // Check if passwords match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("user", user);
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }

        // Check if username already exists
        if (usersRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("user", user);
            model.addAttribute("error", "Username already exists");
            return "register";
        }

        // Create new user entity
        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole("ROLE_USER");
        newUser.setEnabled(true);

        usersRepository.save(newUser);

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
