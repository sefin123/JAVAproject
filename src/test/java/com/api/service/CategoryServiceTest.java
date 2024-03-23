package com.api.service;

import com.api.component.Cache;
import com.api.dao.CategoryRepository;
import com.api.dto.CategoryDTO;
import com.api.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class CategoryServiceTest {
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private Cache cache;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(categoryRepository, cache);
    }

    @Test
    void testGetCategoryFromCache() {
        String categoryName = "Test";
        CategoryDTO cachedCategory = new CategoryDTO(new Category(categoryName));
        when(cache.get(categoryName)).thenReturn(cachedCategory);

        CategoryDTO result = categoryService.getCategory(categoryName);

        assertEquals(cachedCategory, result);
    }

    @Test
    void testGetCategoryFromRepository() {
        String categoryName = "Test";
        Category categoryEntity = new Category(categoryName);
        CategoryDTO categoryDto = new CategoryDTO(categoryEntity);
        when(cache.get(categoryName)).thenReturn(null);
        when(categoryRepository.getCategoryByName(categoryName)).thenReturn(categoryEntity);

        CategoryDTO result = categoryService.getCategory(categoryName);

        assertEquals(categoryDto.getName(), result.getName());
        assertEquals(categoryDto.getId(), result.getId());
        assertEquals(categoryDto.getFoodstuffs(), result.getFoodstuffs());
    }

    @Test
    void testPostCategory() {
        String categoryName = "Test";
        Category categoryEntity = new Category(categoryName);
        Category savedCategory = new Category();

        when(categoryRepository.save(savedCategory)).thenReturn(categoryEntity);

        categoryService.postCategory(categoryName);

        Mockito.verify(categoryRepository, times(1)).save(savedCategory);////////
    }

    @Test
    void testPutCategory() {
        String oldName = "OldCategory";
        String newName = "NewCategory";
        Category categoryEntity = new Category(oldName);
        when(categoryRepository.getCategoryByName(oldName)).thenReturn(categoryEntity);

        categoryService.putCategory(oldName, newName);

        Mockito.verify(categoryRepository, times(1)).getCategoryByName(oldName);
        Mockito.verify(categoryRepository, times(1)).save(categoryEntity);

        assertEquals(newName, categoryEntity.getName());
    }

    @Test
    void testDeleteCategory() {
        String categoryName = "Test";
        Category categoryEntity = new Category();
        when(categoryRepository.getCategoryByName(categoryName)).thenReturn(categoryEntity);

         categoryService.deleteCategory(categoryName);

        Mockito.verify(categoryRepository, times(1)).delete(categoryEntity);
    }

}