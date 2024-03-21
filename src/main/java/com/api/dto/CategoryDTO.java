package com.api.dto;

import com.api.entity.Category;
import com.api.entity.Foodstuff;

import java.util.List;

public class CategoryDTO {

    private Long id;

    private String name;

    private List<Foodstuff> foodstuffs;

    public CategoryDTO() { }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.foodstuffs = category.getFoodstuffs();
    }

    public List<Foodstuff> getList() {
        return foodstuffs;
    }

    public void setFoodstuffs(List<Foodstuff> foodstuffs) {
        this.foodstuffs = foodstuffs;
    }

    public String getCategory() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
