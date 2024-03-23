package com.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodstuffDTOTest {

    @Test
    void constructorAndGetterTest() {
        Long id = 1L;
        String name = "Test";
        int calorie = 1;
        String category = "Test";

        FoodstuffDTO foodstuffDTO = new FoodstuffDTO(id, name, calorie, category);

        assertEquals(id, foodstuffDTO.getId());
        assertEquals(name, foodstuffDTO.getName());
        assertEquals(calorie, foodstuffDTO.getCalorie());
        assertEquals(category, foodstuffDTO.getCategory());
    }

    @Test
    void SetterTest() {
        Long id = 1L;
        String name = "Test";
        int calorie = 1;
        String category = "Test";

        FoodstuffDTO foodstuffDTO = new FoodstuffDTO();

        foodstuffDTO.setCalorie(calorie);
        foodstuffDTO.setId(id);
        foodstuffDTO.setName(name);
        foodstuffDTO.setCategory(category);

        assertEquals(name, foodstuffDTO.getName());
        assertEquals(id, foodstuffDTO.getId());
        assertEquals(calorie, foodstuffDTO.getCalorie());
        assertEquals(category, foodstuffDTO.getCategory());
    }


}