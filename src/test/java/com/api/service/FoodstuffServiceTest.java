package com.api.service;

import com.api.component.Cache;
import com.api.dao.CategoryRepository;
import com.api.dao.FoodstuffRepository;
import com.api.dto.FoodstuffDTO;
import com.api.entity.Category;
import com.api.entity.Foodstuff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class FoodstuffServiceTest {
    private FoodstuffService foodstuffService;

    @Mock
    private FoodstuffRepository foodstuffRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void testGetFoodByNameFromRepository() {
        String foodName = "Test";
        Foodstuff foodstuffEntity = new Foodstuff(foodName, 1, new Category());
        Category categoryEntity = new Category("TestCategory");
        FoodstuffDTO expectedFoodstuff = new FoodstuffDTO(foodstuffEntity);

        when(cache.get(foodName)).thenReturn(null);
        when(foodstuffRepository.getFoodByName(foodName)).thenReturn(foodstuffEntity);
        when(categoryRepository.getCategoryByName(foodstuffEntity.getCategory().getName())).thenReturn(categoryEntity);

        FoodstuffDTO result = foodstuffService.getFoodByName(foodName);

        assertEquals(expectedFoodstuff.getName(), result.getName());
        assertEquals(expectedFoodstuff.getCalorie(), result.getCalorie());
    }

    @Mock
    private Cache cache;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        foodstuffService = new FoodstuffService(foodstuffRepository, categoryRepository, cache);
    }

    @Test
    void testGetFoodByNameFromCache() {
        String foodName = "Test";
        int calorie = 1;
        Category category = new Category();
        FoodstuffDTO cachedFoodstuff = new FoodstuffDTO(new Foodstuff(foodName, calorie, category));
        when(cache.get(foodName)).thenReturn(cachedFoodstuff);

        FoodstuffDTO result = foodstuffService.getFoodByName(foodName);

        assertEquals(cachedFoodstuff, result);
    }

    @Test
    void testPostFoodBulk() {
        List<FoodstuffDTO> foodList = new ArrayList<>();
        foodList.add(new FoodstuffDTO(1L, "Food1", 100, "Category1"));
        foodList.add(new FoodstuffDTO(1L, "Food2", 200, "Category2"));

        Category categoryEntity1 = new Category("Category1");
        Category categoryEntity2 = new Category("Category2");

        when(categoryRepository.getCategoryByName("Category1")).thenReturn(categoryEntity1);
        when(categoryRepository.getCategoryByName("Category2")).thenReturn(categoryEntity2);

        foodstuffService.postFoodBulk(foodList);
    }

    @Test
    void testPostFood() {
        String foodName = "TestFood";
        int calorie = 100;
        String categoryName = "TestCategory";

        Category categoryEntity = new Category(categoryName);

        when(categoryRepository.getCategoryByName(categoryName)).thenReturn(categoryEntity);

        foodstuffService.postFood(foodName, calorie, categoryName);
    }

    @Test
    void testPutFoodName() {
        String oldName = "OldFood";
        String newName = "NewFood";
        int calorie = 1;
        Category category = new Category();
        Foodstuff foodstuffEntity = new Foodstuff(oldName, calorie, category);
        when(foodstuffRepository.getFoodByName(oldName)).thenReturn(foodstuffEntity);

        foodstuffService.putFoodName(oldName, newName);
    }

    @Test
    void testDeleteFoodByName() {
        String foodName = "Test";
        int calorie = 1;
        Category category = new Category();
        Foodstuff foodstuffEntity = new Foodstuff(foodName, calorie, category);

        when(foodstuffRepository.getFoodByName(foodName)).thenReturn(null);

        foodstuffService.deleteFoodByName(foodName);

        assertNull(foodstuffRepository.getFoodByName(foodName));
    }

}