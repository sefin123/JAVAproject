package com.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "foodstuffs")
public class FoodstuffsEntity {

        @Id
        @Column(name = "id")
        private Long id;

        @Column(name = "food_name")
        private String foodName;

        @Column(name = "food_calorie")
        private int valueCalorie;

    public FoodstuffsEntity() {}

    public FoodstuffsEntity(String foodName, int valueCalorie) {
        this.foodName = foodName;
        this.valueCalorie = valueCalorie;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getValuecalorie() {
        return valueCalorie;
    }

    public void setValuecalorie(int valuecalorie) {
        valueCalorie = valuecalorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

