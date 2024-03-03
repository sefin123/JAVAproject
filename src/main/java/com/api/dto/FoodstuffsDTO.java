package com.api.dto;



public class FoodstuffsDTO {

    private String id;

    private String name;

    private int calorie;

    private String category;

    public FoodstuffsDTO(String id, String name, int calorie, String category) {
        this.id = id;
        this.name = name;
        this.calorie = calorie;
        this.category = category;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
