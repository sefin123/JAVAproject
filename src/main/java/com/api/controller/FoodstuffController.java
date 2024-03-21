package com.api.controller;

import com.api.dto.FoodstuffDTO;
import com.api.entity.Foodstuff;
import com.api.service.FoodstuffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodstuffController {

    private final FoodstuffService foodstuffService;

    public FoodstuffController(FoodstuffService service) {
        this.foodstuffService = service;
    }

    @GetMapping("/food")
    public ResponseEntity<FoodstuffDTO> getFoodByName(@RequestParam String name) {
        return ResponseEntity.ok(foodstuffService.getFoodByName(name));
    }

    @PostMapping("/food")
    public String postFood(@RequestParam String name, int calorie, String category) {
        foodstuffService.postFood(name, calorie, category);
        return "Posted food.";
    }

    @PostMapping("/food/bulk")
    public String postFoodBulk(@RequestBody List<FoodstuffDTO> food) {
        foodstuffService.postFoodBulk(food);
        return "Posted food.";
    }

    @PutMapping("/food")
    public String putFood(@RequestParam String oldName, String newName) {
        foodstuffService.putFoodName(oldName, newName);
        return "Renamed food.";
    }

    @DeleteMapping("/food")
    public String deleteFood(@RequestParam String name) {
        foodstuffService.deleteFoodByName(name);
        return "Deleted food.";
    }

}
