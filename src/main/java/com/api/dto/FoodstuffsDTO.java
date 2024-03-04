package com.api.dto;


import com.api.entity.FoodstuffsEntity;

public class FoodstuffsDTO {

    private Long id;

    private String name;

    private int calorie;

    private String category;

    public FoodstuffsDTO(Long id, String name, int calorie, String category) {
        this.id = id;
        this.name = name;
        this.calorie = calorie;
        this.category = category;
    }

    public FoodstuffsDTO(FoodstuffsEntity foodstuffsEntity) {
        this.id = foodstuffsEntity.getId();
        this.name = foodstuffsEntity.getFoodName();
        this.calorie = foodstuffsEntity.getValuecalorie();
        this.category = foodstuffsEntity.getCategory().getCategory();

    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
