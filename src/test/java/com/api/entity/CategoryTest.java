package com.api.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void constructorAndGetterTest() {
        String name = "Test";
        List<Foodstuff> list = new ArrayList<>();
        Foodstuff food = new Foodstuff(name, 1, new Category());
        Category category = new Category(name);
        list.add(food);

        assertEquals(name, list.getFirst().getName());
        assertEquals(name, category.getName());
    }

    @Test
    void setterTest() {
        Long id = 1L;
        String name = "Test";

        Category category = new Category();
        category.setId(id);
        category.setName(name);

        assertEquals(id, category.getId());
        assertEquals(name, category.getName());
    }

}