package com.api.controller;

import com.api.dto.FoodstuffsDTO;
import com.api.service.FoodstuffsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodstuffsController {
    private final FoodstuffsService foodstuffsService;

    public FoodstuffsController(FoodstuffsService service) {
        this.foodstuffsService = service;
    }
    @GetMapping("/get")
    public FoodstuffsDTO processUrl(@RequestParam String text) {
        int food = foodstuffsService.getCalorie(text);
        return new FoodstuffsDTO(food);
    }
}