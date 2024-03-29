package com.api.controller;

import com.api.dto.FoodstuffDTO;
import com.api.service.FoodstuffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FoodstuffController {

    private final FoodstuffService foodstuffService;

    static final String SUCCESS_MSG = "Success";

    public FoodstuffController(FoodstuffService service) {
        this.foodstuffService = service;
    }

    @GetMapping("/food")
    public ResponseEntity<FoodstuffDTO> getFood(@RequestParam String name) {
        log.info("Call get food request");
        return ResponseEntity.ok(foodstuffService.getFoodByName(name));
    }

    @PostMapping("/food")
    public ResponseEntity<String> postFood(@RequestParam String name, int calorie, String category) {
        log.info("Call post food request");
        foodstuffService.postFood(name, calorie, category);
        return ResponseEntity.ok(SUCCESS_MSG);
    }

    @PostMapping("/food/bulk")
    public ResponseEntity<String> postFoodBulk(@RequestBody List<FoodstuffDTO> food) {
        log.info("Call post(bulk) food request");
        foodstuffService.postFoodBulk(food);
        return ResponseEntity.ok(SUCCESS_MSG);
    }

    @PutMapping("/food")
    public ResponseEntity<String> putFood(@RequestParam String oldName, String newName) {
        log.info("Call put food request");
        foodstuffService.putFoodName(oldName, newName);
        return ResponseEntity.ok(SUCCESS_MSG);
    }

    @DeleteMapping("/food")
    public ResponseEntity<String> deleteFood(@RequestParam String name) {
        log.info("Call delete food request");
        foodstuffService.deleteFoodByName(name);
        return ResponseEntity.ok(SUCCESS_MSG);
    }

}
