package com.api.controller;

import com.api.dto.CategoryDTO;
import com.api.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<CategoryDTO> getCategory(String name) {
        return ResponseEntity.ok(categoryService.getCategoriesEntity(name));
    }

    @PostMapping("/category")
    public String postCategory(String name) {
        categoryService.postCategoriesEntity(name);
        return "Posted category.";
    }

    @PutMapping("/category")
    public String putCategory(String oldName, String newName) {
        categoryService.putCategoriesEntity(oldName, newName);
        return "Putted category.";
    }

    @DeleteMapping("/category")
    public String deleteCategory(String name) {
        categoryService.deleteCategoriesEntity(name);
        return "Deleted category.";
    }

}
