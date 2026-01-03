package com.mycafe.model;

import javax.validation.constraints.*;

public class Customer {
    @NotEmpty(message = "Name cannot be empty.")
    @Size(min = 10, max = 30)
    private String fullName;

    @NotEmpty(message = "Age cannot be empty.")
    @Min(1)
    @Max(100)
    private Integer age;

    @NotEmpty(message = "Address cannot be empty.")
    @Size(min = 20, max = 100)
    private String shippingAddress;

    private boolean hasGoldMembership;

    public Customer() {}

    public Customer(String fullName, int age, String shippingAddress, boolean hasGoldMembership) {
        this.fullName = fullName;
        this.age = age;
        this.shippingAddress = shippingAddress;
        this.hasGoldMembership = hasGoldMembership;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public boolean isHasGoldMembership() {
        return hasGoldMembership;
    }
    public void setHasGoldMembership(boolean hasGoldMembership) {
        this.hasGoldMembership = hasGoldMembership;
    }
}
