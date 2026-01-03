package com.mycafe.model;

public class OrderItem {
    private String mealSet;
    private String drink;
    private int quantity;
    private double price;

    public OrderItem(String mealSet, String drink, int quantity) {
        this.mealSet = mealSet;
        this.drink = drink;
        this.quantity = quantity;
    }

    public String getMealSet() {
        return mealSet;
    }

    public void setMealSet(String mealSet) {
        this.mealSet = mealSet;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
