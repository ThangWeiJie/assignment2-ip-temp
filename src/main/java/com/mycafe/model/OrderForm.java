package com.mycafe.model;

import javax.validation.Valid;
import java.util.List;

public class OrderForm {
    @Valid
    private OrderItem set1;

    @Valid
    private OrderItem set2;

    private Double totalPrice;
    private Double amountToPay;
    private Double seniorDiscount;
    private Double membershipDiscount;

    public OrderForm() {}

    public List<OrderItem> getItems() {
        return List.of(set1, set2);
    }

    public OrderItem getSet1() {
        return set1;
    }
    public void setSet1(OrderItem set1) {
        this.set1 = set1;
    }

    public OrderItem getSet2() {
        return set2;
    }
    public void setSet2(OrderItem set2) {
        this.set2 = set2;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getSeniorDiscount() {
        return seniorDiscount;
    }
    public void setSeniorDiscount(Double seniorDiscount) {
        this.seniorDiscount = seniorDiscount;
    }

    public Double getMembershipDiscount() {
        return membershipDiscount;
    }
    public void setMembershipDiscount(Double membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }

    public Double getAmountToPay() {
        return amountToPay;
    }
    public void setAmountToPay(Double amountToPay) {
        this.amountToPay = amountToPay;
    }
}
