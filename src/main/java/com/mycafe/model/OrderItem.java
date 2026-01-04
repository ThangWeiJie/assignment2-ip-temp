package com.mycafe.model;

import org.hibernate.validator.constraints.Range;

public class OrderItem {
    private String mealSet;
    private String drink;

    @Range(min = 0, max = 20)
    private Integer quantity;

    private Double price;

    private boolean selected;

    public OrderItem() {}

    public OrderItem(String mealSet, String drink, Integer quantity) {
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

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
