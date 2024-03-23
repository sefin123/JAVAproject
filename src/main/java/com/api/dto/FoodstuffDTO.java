package com.api.dto;

import com.api.entity.Foodstuff;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    public FoodstuffDTO() { }

}
