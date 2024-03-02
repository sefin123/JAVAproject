package com.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit")
public class FruitEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodstuff_id")
    private FoodstuffsEntity foodstuff;

    @Column(name = "name")
    private String foodName;

    @Column(name = "color")
    private String color;

    public FruitEntity() {}

    public FruitEntity(FoodstuffsEntity foodstuff, String name, String color) {
        this.foodstuff = foodstuff;
        this.foodName = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
