package com.api.dto;

public class FoodstuffsDTO {

    int id;

    String foodName;

    int calorie;

    public FoodstuffsDTO(int id, String foodName, int calorie) {
        this.id = id;
        this.foodName = foodName;
        this.calorie = calorie;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }
}
