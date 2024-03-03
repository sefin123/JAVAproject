package com.api.controller;

import com.api.entity.FoodstuffsEntity;
import com.api.service.CategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    private CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/category")
    public ResponseEntity<List<FoodstuffsEntity>> getCategory(String category) {
        return ResponseEntity.ok(categoriesService.getCategoriesEntity(category));
    }

    @PostMapping("/category")
    public String postCategory(String category) {
        categoriesService.postCategoriesEntity(category);
        return "Posted category.";
    }

    @PutMapping("/category")
    public String putCategory(String oldName, String newName) {
        categoriesService.putCategoriesEntity(oldName, newName);
        return "Putted category.";
    }

    @DeleteMapping("/category")
    public String deleteCategory(String category) {
        categoriesService.deleteCategoriesEntity(category);
        return "Deleted category.";
    }

    public CategoriesService getCategoriesService() {
        return categoriesService;
    }

    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
}
