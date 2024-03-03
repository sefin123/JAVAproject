package com.api.controller;

import com.api.entity.FoodstuffsEntity;
import com.api.service.FoodstuffsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodstuffsController {

    private final FoodstuffsService foodstuffsService;

    public FoodstuffsController(FoodstuffsService service) {
        this.foodstuffsService = service;
    }

    @GetMapping("/food")
    public ResponseEntity<FoodstuffsEntity> getFood(@RequestParam String name) {
        return ResponseEntity.ok(foodstuffsService.getFood(name));
    }

    @PostMapping("/food")
    public ResponseEntity<FoodstuffsEntity> postFood(@RequestParam String name, int calorie, String category) {
        return ResponseEntity.ok(foodstuffsService.postFood(name, calorie, category));
    }

    @PutMapping("/food")
    public String putFood(@RequestParam String oldName, String newName) {
        foodstuffsService.putFoodName(oldName, newName);
        return "Renamed food.";
    }

    @DeleteMapping("/food")
    public String deleteFood(@RequestParam String name) {
        foodstuffsService.deleteFoodByName(name);
        return "Deleted food.";
    }
}
