package com.api.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void constructorAndGetterTest() {
        String name = "Test";

        Category category = new Category(name);

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