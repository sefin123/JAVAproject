package com.api.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "foodstuffs")
public class FoodstuffsEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String foodName;

        @Column(name = "calorie")
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

    public FoodstuffsEntity SearchByName(List<FoodstuffsEntity> entities, String foodName) {
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getFoodName(), foodName)) {
                break;
            }
        }
        return entities.get(i);
    }

}
