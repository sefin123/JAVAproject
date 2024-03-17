package com.api.service;

import com.api.component.Cache;
import com.api.dao.CategoryRepository;
import com.api.dao.FoodstuffRepository;
import com.api.dto.FoodstuffDTO;
import com.api.entity.Category;
import com.api.entity.Foodstuff;
import org.springframework.stereotype.Service;

@Service
public class FoodstuffService {

    private final FoodstuffRepository foodstuffRepository;

    private final CategoryRepository categoryRepository;

    private final Cache cache;

    public FoodstuffService(FoodstuffRepository foodstuffRepository, CategoryRepository categoryRepository, Cache cache) {
        this.foodstuffRepository = foodstuffRepository;
        this.categoryRepository = categoryRepository;
        this.cache = cache;
    }

    public FoodstuffDTO getFoodByName(String name) {

        FoodstuffDTO food = (FoodstuffDTO) cache.get(name);
        if(food != null) return food;

        Foodstuff foodstuffEntity = foodstuffRepository.getFoodByName(name);
        Category categoryEntity = categoryRepository.getCategoryByName(foodstuffEntity.getCategory().getName());

        foodstuffEntity.setCategory(categoryEntity);

        cache.put(name, new FoodstuffDTO(foodstuffEntity));

        return new FoodstuffDTO(foodstuffEntity);
    }

    public void postFood(String name, int calorie, String category) {
        Category categoryEntity = categoryRepository.getCategoryByName(category);

        Foodstuff foodstuff = new Foodstuff(name, calorie, categoryEntity);

        foodstuffRepository.save(foodstuff);
    }

    public void putFoodName(String oldName, String newName) {
        Foodstuff entity = foodstuffRepository.getFoodByName(oldName);

        entity.setName(newName);

        cache.remove(oldName);

        foodstuffRepository.save(entity);
    }

    public void deleteFoodByName(String name) {
        Foodstuff entity = foodstuffRepository.getFoodByName(name);

        foodstuffRepository.delete(entity);
    }

}