package com.api.dto;

import com.api.entity.Foodstuff;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDTOTest {

    @Test
    void constructorAndGetterTest() {
        Long id = 1L;
        String name = "Test";
        List<Foodstuff> foodstuffs = new ArrayList<>();

        CategoryDTO categoryDTO = new CategoryDTO(id, name, foodstuffs);

        assertEquals(name, categoryDTO.getName());
        assertEquals(foodstuffs, categoryDTO.getFoodstuffs());
    }

    @Test
    void setterTest() {
        String name = "Test";
        Long id = 1L;

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setName(name);
        categoryDTO.setId(id);

        assertEquals(name, categoryDTO.getName());
        assertEquals(id, categoryDTO.getId());
    }

}