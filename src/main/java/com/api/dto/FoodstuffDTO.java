package com.api.dto;


import com.api.entity.Foodstuff;

public class FoodstuffDTO {

    private Long id;

    private String name;

    private int calorie;

    private String category;

    public FoodstuffDTO(Long id, String name, int calorie, String category) {
        this.id = id;
        this.name = name;
        this.calorie = calorie;
        this.category = category;
    }

    public FoodstuffDTO(Foodstuff foodstuff) {
        this.id = foodstuff.getId();
        this.name = foodstuff.getName();
        this.calorie = foodstuff.getCalorie();
        this.category = foodstuff.getCategory().getName();

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
