package com.mycafe.controller;

import com.mycafe.model.Customer;
import com.mycafe.model.OrderForm;
import com.mycafe.model.PaymentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CustomerPaymentController {
    @GetMapping("/customer/payment")
    public String showPaymentPage(Model model) {
        model.addAttribute("paymentForm", new PaymentForm());
        return "customer_payment";
    }

    @PostMapping("/customer/payment")
    public String processPayment(@SessionAttribute("customer") Customer customer, @ModelAttribute("paymentForm") PaymentForm paymentForm) {
        customer.setPaymentMethod(paymentForm.getPaymentMethod());
        return "redirect:/customer/invoice";
    }
}
