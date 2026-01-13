package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.data.OrdersDataService;
import com.gcu.models.OrderModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersDataService ordersDataService;

    // Show all orders
    @GetMapping("")
    public String showAllOrders(Model model) {
        model.addAttribute("title", "All Orders");
        model.addAttribute("orders", ordersDataService.getAll());
        return "allOrders";
    }

    // Show one order
    @GetMapping("/showOrder/{id}")
    public String showOrder(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", "Order Details");
        model.addAttribute("order", ordersDataService.getById(id));
        return "showOrder";
    }

    // Show edit form
    @GetMapping("/editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", "Edit Order");
        model.addAttribute("order", ordersDataService.getById(id));
        return "editOrder";
    }

    // Process edit form
    @PostMapping("/processEditOrder")
    public String processEditOrder(@ModelAttribute OrderModel order) {
        ordersDataService.update(order);
        return "redirect:/orders";
    }

    // Show new order form
    @GetMapping("/newOrder")
    public String newOrder(Model model) {
        model.addAttribute("title", "New Order");
        model.addAttribute("order", new OrderModel());
        return "newOrder";
    }

    // Process new order form
    @PostMapping("/processNewOrder")
    public String processNewOrder(@ModelAttribute OrderModel order) {
        ordersDataService.create(order);
        return "redirect:/orders";
    }

    // Delete order
    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        ordersDataService.deleteById(id);
        return "redirect:/orders";
    }
}
