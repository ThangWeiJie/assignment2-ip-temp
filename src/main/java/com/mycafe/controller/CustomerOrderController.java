package com.mycafe.controller;

import com.mycafe.model.Customer;
import com.mycafe.model.OrderForm;
import com.mycafe.model.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("orderForm")
public class CustomerOrderController {
    @GetMapping("/customer/order")
    public String showOrderPage(Model model) {
        OrderForm orderForm = new OrderForm();

        orderForm.setSet1(new OrderItem("Hashbrown Set", null, 0));
        orderForm.setSet2(new OrderItem("Hotcakes Set", null, 0));

        model.addAttribute("orderForm", orderForm);

        return "customer_order_form";
    }

    @PostMapping("/customer/order")
    public String processOrder(@SessionAttribute("customer") Customer customer, @Valid @ModelAttribute("orderForm") OrderForm orderForm, BindingResult result) {
        validateDrink(orderForm.getSet1(), "set1", result);
        validateDrink(orderForm.getSet2(), "set2", result);

        if (result.hasErrors()) {
            return "customer_order_form";
        }

        double totalPrice = 0;
        double seniorDiscount = 0;
        double memberDiscount = 0;

        for (OrderItem item : List.of(orderForm.getSet1(), orderForm.getSet2())) {
            if (item.isSelected() && item.getQuantity() > 0) {
                item.setPrice(calculatePrice(item));
            } else {
                item.setPrice(0.0);
                item.setQuantity(0);
                item.setDrink(null);
            }

            totalPrice += item.getPrice();
        }

        if (customer.isHasGoldMembership()) {
            memberDiscount = totalPrice * 0.10;
            orderForm.setMembershipDiscount(memberDiscount);
        } else {
            orderForm.setMembershipDiscount(0.0);
        }

        if (customer.getAge() >= 55) {
            seniorDiscount = totalPrice * 0.05;
            orderForm.setSeniorDiscount(seniorDiscount);
        } else {
            orderForm.setSeniorDiscount(0.0);
        }


        double amountToPay = totalPrice - (seniorDiscount + memberDiscount);
        orderForm.setTotalPrice(totalPrice);
        orderForm.setAmountToPay(amountToPay);

        return "redirect:/customer/payment";
    }

    private void validateDrink(OrderItem item, String fieldPrefix, BindingResult result) {
        if (item.getQuantity() != null && item.getQuantity() > 0) {
            if (item.getDrink() == null || item.getDrink().isBlank()) {
                result.rejectValue(
                        fieldPrefix + ".drink",
                        "drink.required",
                        "Please select a drink"
                );
            }
        }
    }

    private double calculatePrice(OrderItem item) {
        double unitPrice = 0;

        switch (item.getMealSet()) {
            case "Hashbrown Set"->
                unitPrice = switch (item.getDrink()) {
                    case "coffee" -> 10.0;
                    case "milo" -> 13.0;
                    default -> 0.0;
                };
            case "Hotcakes Set"->
                unitPrice = switch (item.getDrink()) {
                    case "coffee" -> 11.0;
                    case "milo" -> 15.0;
                    case "lemon tea" -> 12.0;
                    default -> 0.0;
                };
        }

        return unitPrice * item.getQuantity();
    }
}
