package com.api.controller;

import com.api.dto.CategoryDTO;
import com.api.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryController = new CategoryController(categoryService);
    }

    @Test
    void getCategory_ReturnsOkResponseWithCategoryDTO() {
        String categoryName = "Test category";
        CategoryDTO expectedCategory = new CategoryDTO();

        when(categoryService.getCategory(categoryName)).thenReturn(expectedCategory);

        ResponseEntity<CategoryDTO> response = categoryController.getCategory(categoryName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCategory, response.getBody());
    }

    @Test
    void postCategory_ReturnsSuccessMessage() {
        String categoryName = "Test Category";

        ResponseEntity<String> response = categoryController.postCategory(categoryName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void putCategory_ReturnsSuccessMessage() {
        String oldName = "Old Category";
        String newName = "New Category";

        ResponseEntity<String> response = categoryController.putCategory(oldName, newName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteCategory_ReturnsSuccessMessage() {
        String categoryName = "Test Category";

        ResponseEntity<String> response = categoryController.deleteCategory(categoryName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}