package com.api.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodstuffTest {

    @Test
    void setterTest() {
        Long id = 1L;
        String name = "Test";
        int calorie = 1;

        Category category = new Category();

        Foodstuff foodstuff = new Foodstuff();
        foodstuff.setId(id);
        foodstuff.setName(name);
        foodstuff.setCalorie(calorie);
        foodstuff.setCategory(category);

        assertEquals(id, foodstuff.getId());
        assertEquals(name, foodstuff.getName());
        assertEquals(calorie, foodstuff.getCalorie());
        assertSame(category, foodstuff.getCategory());
    }

    @Test
    void testConstructorAndGetter() {

        String name = "Test";
        int calorie = 1;
        Category category = new Category();

        Foodstuff foodstuff = new Foodstuff(name, calorie, category);

        assertEquals(name, foodstuff.getName());
        assertEquals(calorie, foodstuff.getCalorie());
        assertSame(category, foodstuff.getCategory());
    }

}