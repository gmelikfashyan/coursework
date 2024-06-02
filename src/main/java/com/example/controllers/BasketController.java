package com.example.controllers;

import com.example.entities.Product;
import com.example.entities.AmountsProduct;
import com.example.entities.Order;
import com.example.entities.OrderItem;
import com.example.security.MyUserDetails;
import com.example.services.EmailService;
import com.example.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class BasketController {
    @Autowired
    private OrderService orderService;
    private final EmailService emailService;
    public BasketController(OrderService orderService, EmailService emailService)
    {
        this.orderService = orderService;
        this.emailService = emailService;
    }
    private AmountsProduct amountsProduct = new AmountsProduct(1);
    @PostMapping("/basketPost")
    public String getNumberOfItems(@ModelAttribute AmountsProduct amountsProduct)
    {
        this.amountsProduct = amountsProduct;
        return "redirect:/basket";
    }
    @GetMapping("/basket")
    public String getShoppingCart(Model model)
    {
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        order.setOrderItems(orderItems);
        for (int i = 0; i < amountsProduct.getNumber(); i++)
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(new Product());
            order.addOrderItem(orderItem);
        }
        model.addAttribute("amountsProduct", amountsProduct);
        model.addAttribute("order", order);
        return "basket";
    }
    @PostMapping("/add-order")
    public String addNewOrder(@ModelAttribute Order order, @ModelAttribute OrderItem orderItems,
                              @AuthenticationPrincipal MyUserDetails myUserDetails)
    {
        order.setUser(myUserDetails.getUser());
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        order.setOrderDate(currentDate.format(formatter));
        ArrayList<String> arrayList = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems())
        {
            orderService.saveOrderItem(orderItem);
            arrayList.add(orderItem.getProduct().getName() + " " + orderItem.getProduct().getBrand());
        }
        orderService.saveOrder(order);
        emailService.sendEmail(order.getUser().getUsername(), "ManStyle - магазин одежды", "Здравствуйте, " + order.getUser().getName() + "!" + "\n\nВаш заказ на сумму " + order.getTotalCost() + "₽" +  " успешно сформирован!\n\nЗаказ:\n" + String.join("\n", arrayList) + "\n\nСпасибо за лояльность к нашему магазину!" + "\n\nC уважением, ManStyle");
        return "redirect:account";
    }
}
