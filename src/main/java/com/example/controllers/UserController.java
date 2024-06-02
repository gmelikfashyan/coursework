package com.example.controllers;

import com.example.entities.User;
import com.example.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController
{
    private UserService userService;

    @PostMapping("registration")
    public String addUser(@ModelAttribute("userReg") User user)
    {
        userService.addUser(user);
        return "redirect:login";
    }
    @GetMapping("login")
    public String getRegistration(Model model)
    {
        model.addAttribute("userReg", new User());
        return "authorization";
    }
}
