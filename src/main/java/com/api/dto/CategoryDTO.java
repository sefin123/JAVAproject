package com.api.dto;

import com.api.entity.Category;
import com.api.entity.Foodstuff;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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

    public CategoryDTO(Long id, String name, List<Foodstuff> foodstuffs) {
        this.id = id;
        this.name = name;
        this.foodstuffs = foodstuffs;
    }

}
