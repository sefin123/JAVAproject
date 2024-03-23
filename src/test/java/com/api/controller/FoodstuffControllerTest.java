package com.api.controller;

import com.api.dto.FoodstuffDTO;
import com.api.service.FoodstuffService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class FoodstuffControllerTest {

    @Mock
    private FoodstuffService foodstuffService;

    private FoodstuffController foodstuffController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        foodstuffController = new FoodstuffController(foodstuffService);
    }

    @Test
    void getFood_ReturnOkResponseWithFoodstuffDTO() {
        String name = "Test";
        FoodstuffDTO expectedFood = new FoodstuffDTO();

        when(foodstuffService.getFoodByName(name)).thenReturn(expectedFood);

        ResponseEntity<FoodstuffDTO> response = foodstuffController.getFood(name);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedFood, response.getBody());

    }

    @Test
    void postFood_ReturnsSuccessMessage() {
        String name = "Test";
        int calorie = 1;
        String category = "Test";

        ResponseEntity<String> response = foodstuffController.postFood(name, calorie, category);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void putFood_ReturnsSuccessMessage() {
        String oldName = "Old name";
        String newName = "New name";

        ResponseEntity<String> response = foodstuffController.putFood(oldName, newName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteFood_ReturnsSuccessMessage() {
        String name = "Test";

        ResponseEntity<String> response = foodstuffController.deleteFood(name);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}