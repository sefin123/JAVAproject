package com.api.service;

import com.api.dao.CategoryRepository;
import com.api.dao.FoodstuffRepository;
import com.api.dto.FoodstuffDTO;
import com.api.entity.Category;
import com.api.entity.Foodstuff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FoodstuffService {

    private final FoodstuffRepository foodstuffRepository;

    private final CategoryRepository categoryRepository;

    public FoodstuffService(FoodstuffRepository foodstuffRepository, CategoryRepository categoryRepository) {
        this.foodstuffRepository = foodstuffRepository;
        this.categoryRepository = categoryRepository;
    }

    public FoodstuffDTO getFood(String name) {
        List<Foodstuff> entities = foodstuffRepository.findAll();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getName(), name)) {
                break;
            }
        }

        List<Category> list = categoryRepository.findAll();
        int j = 0;
        for (; j < list.size(); j++) {
            if (Objects.equals(list.get(j), entities.get(i).getCategory())) {
                break;
            }
        }
        entities.get(i).setCategory(list.get(j));
        return new FoodstuffDTO(entities.get(i));
    }

    public void postFood(String name, int calorie, String category) {
        List<Category> list = categoryRepository.findAll();
        int j = 0;
        for (; j < list.size(); j++) {
            if (Objects.equals(list.get(j).getName(), category)) {
                break;
            }
        }
        Foodstuff foodstuff = new Foodstuff(name, calorie, list.get(j));
        foodstuffRepository.save(foodstuff);
    }

    public void putFoodName(String oldName, String newName) {
        List<Foodstuff> entities = foodstuffRepository.findAll();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getName(), oldName)) {
                break;
            }
        }
        entities.get(i).setName(newName);
        foodstuffRepository.saveAll(entities);
    }

    public void deleteFoodByName(String name) {
        List<Foodstuff> entities = foodstuffRepository.findAll();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getName(), name)) {
                break;
            }
        }
        foodstuffRepository.delete(entities.get(i));
    }
}