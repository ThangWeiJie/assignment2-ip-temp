package com.mycafe.controller;

import com.mycafe.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class CustomerDetailController {
    @GetMapping("/customer/details")
    public String showCustomerDetailsPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer_detail_form";
    }

    @PostMapping("/customer/details")
    public String processCustomerDetails(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer_detail_form";
        }

        return "redirect:/customer/order";
    }
}
