package com.example.controllers;

import com.example.entities.AmountsProduct;
import com.example.security.CustomUserDetails;
import com.example.services.ProductService;
import com.example.services.EmailService;
import com.example.services.OrderService;
import com.example.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    private final EmailService emailService;

    public OrderController(OrderService orderService, ProductService productService, EmailService emailService)
    {
        this.orderService = orderService;
        this.productService = productService;
        this.emailService = emailService;
    }
    private AmountsProduct amountsProduct = new AmountsProduct(1);


    @GetMapping("/")
    public String getStart()
    {
        return "redirect:account";
    }

    @GetMapping("/catalog")
    public String getCatalog(Model model)
    {
        model.addAttribute("amountsProduct", amountsProduct);
        model.addAttribute("productList", productService.findAll());
        return "catalog";
    }

    @GetMapping("/account")
    public String getAccount(Model model , @AuthenticationPrincipal CustomUserDetails customUserDetails)
    {
        Long id = customUserDetails.getUser().getId();
        model.addAttribute("amountsProduct", amountsProduct);
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("orders", orderService.getOrdersByUserId(id));
        return "account";
    }
}
