package com.mycafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerInvoiceController {
    @GetMapping("/customer/invoice")
    public String showInvoicePage() {
        return "customer_invoice";
    }
}
