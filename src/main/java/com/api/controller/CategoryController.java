package com.api.controller;

import com.api.dto.CategoryDTO;
import com.api.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<CategoryDTO> getCategory(String category) {
        return ResponseEntity.ok(categoryService.getCategoriesEntity(category));
    }

    @PostMapping("/category")
    public String postCategory(String category) {
        categoryService.postCategoriesEntity(category);
        return "Posted category.";
    }

    @PutMapping("/category")
    public String putCategory(String oldName, String newName) {
        categoryService.putCategoriesEntity(oldName, newName);
        return "Putted category.";
    }

    @DeleteMapping("/category")
    public String deleteCategory(String category) {
        categoryService.deleteCategoriesEntity(category);
        return "Deleted category.";
    }

    public CategoryService getCategoriesService() {
        return categoryService;
    }

    public void setCategoriesService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
