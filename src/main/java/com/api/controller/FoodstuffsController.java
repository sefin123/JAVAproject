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
    @GetMapping("/get")
    public ResponseEntity<FoodstuffsEntity> getFood(@RequestParam String foodName) {
        return ResponseEntity.ok(foodstuffsService.getFood(foodName));
    }

    @PostMapping("/post")
    public ResponseEntity<FoodstuffsEntity> postFood(@RequestParam String foodName, int calorie) {
        return ResponseEntity.ok(foodstuffsService.postFood(foodName, calorie));
    }

    @PutMapping("/put")
    public ResponseEntity<FoodstuffsEntity> putFoodByName(@RequestParam String oldFoodName, String newFoodName) {
        return ResponseEntity.ok(foodstuffsService.putFoodName(oldFoodName, newFoodName));
    }

    @DeleteMapping("/delete")
    public String deleteFoodByName(@RequestParam String foodName) {
        foodstuffsService.deleteFoodByName(foodName);
        return "Completed";
    }
}
