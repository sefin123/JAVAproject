package com.api.controller;

import com.api.dto.CategoryDTO;
import com.api.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService categoryService;

    static final String SUCCESS_MSG = "Success";

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<CategoryDTO> getCategory(String name) {
        log.info("Call get category request");
        return ResponseEntity.ok(categoryService.getCategory(name));
    }

    @PostMapping("/category")
    public ResponseEntity<String> postCategory(String name) {
        log.info("Call post category request");
        categoryService.postCategory(name);
        return ResponseEntity.ok(SUCCESS_MSG);
    }

    @PutMapping("/category")
    public ResponseEntity<String> putCategory(String oldName, String newName) {
        log.info("Call put category request");
        categoryService.putCategory(oldName, newName);
        return ResponseEntity.ok(SUCCESS_MSG);
    }

    @DeleteMapping("/category")
    public ResponseEntity<String> deleteCategory(String name) {
        log.info("Call delete category request");
        categoryService.deleteCategory(name);
        return ResponseEntity.ok(SUCCESS_MSG);
    }

}
