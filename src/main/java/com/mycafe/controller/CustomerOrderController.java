package com.mycafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerOrderController {
    @GetMapping("/customer/order")
    public String showOrderPage() {
        return "customer_order_form";
    }
}
