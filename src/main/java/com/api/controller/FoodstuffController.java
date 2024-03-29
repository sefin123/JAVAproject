package com.api.controller;

import com.api.dto.FoodstuffDTO;
import com.api.service.FoodstuffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodstuffController {

    private final FoodstuffService foodstuffService;

    static final String SUCCESS_CODE = "Success";

    public FoodstuffController(FoodstuffService service) {
        this.foodstuffService = service;
    }

    @GetMapping("/food")
    public ResponseEntity<FoodstuffDTO> getFood(@RequestParam String name) {
        return ResponseEntity.ok(foodstuffService.getFoodByName(name));
    }

    @PostMapping("/food")
    public ResponseEntity<String> postFood(@RequestParam String name, int calorie, String category) {
        foodstuffService.postFood(name, calorie, category);
        return ResponseEntity.ok(SUCCESS_CODE);
    }

    @PostMapping("/food/bulk")
    public ResponseEntity<String> postFoodBulk(@RequestBody List<FoodstuffDTO> food) {
        foodstuffService.postFoodBulk(food);
        return ResponseEntity.ok(SUCCESS_CODE);
    }

    @PutMapping("/food")
    public ResponseEntity<String> putFood(@RequestParam String oldName, String newName) {
        foodstuffService.putFoodName(oldName, newName);
        return ResponseEntity.ok(SUCCESS_CODE);
    }

    @DeleteMapping("/food")
    public ResponseEntity<String> deleteFood(@RequestParam String name) {
        foodstuffService.deleteFoodByName(name);
        return ResponseEntity.ok(SUCCESS_CODE);
    }

}
