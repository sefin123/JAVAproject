package com.api.entity;

import jakarta.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoriesEntity category;

    public FoodstuffsEntity() {}

    public FoodstuffsEntity(String foodName, int valueCalorie, CategoriesEntity category) {
        this.foodName = foodName;
        this.valueCalorie = valueCalorie;
        this.category = category;
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

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }
}
