package com.api.controller;

import com.api.dto.CategoryDTO;
import com.api.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    static final String SUCCESS_CODE = "Success";

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<CategoryDTO> getCategory(String name) {
        return ResponseEntity.ok(categoryService.getCategory(name));
    }

    @PostMapping("/category")
    public ResponseEntity<String> postCategory(String name) {
        categoryService.postCategory(name);
        return ResponseEntity.ok(SUCCESS_CODE);
    }

    @PutMapping("/category")
    public ResponseEntity<String> putCategory(String oldName, String newName) {
        categoryService.putCategory(oldName, newName);
        return ResponseEntity.ok(SUCCESS_CODE);
    }

    @DeleteMapping("/category")
    public ResponseEntity<String> deleteCategory(String name) {
        categoryService.deleteCategory(name);
        return ResponseEntity.ok(SUCCESS_CODE);
    }

}
