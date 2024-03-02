package com.api.service;

import com.api.dao.FoodstuffsDAO;
import com.api.entity.FoodstuffsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FoodstuffsService {
    private final FoodstuffsDAO foodstuffsDao;

    public FoodstuffsService(FoodstuffsDAO foodstuffsDao) {
        this.foodstuffsDao = foodstuffsDao;
    }

    public FoodstuffsEntity getFood(String foodName) {
        List<FoodstuffsEntity> entities = foodstuffsDao.loadEntity();
        return new FoodstuffsEntity().SearchByName(entities, foodName);
    }

    public FoodstuffsEntity postFood(String foodName, int calorie) {
        FoodstuffsEntity foodstuffsEntity = new FoodstuffsEntity(foodName, calorie);
        foodstuffsDao.postEntity(foodstuffsEntity);
        return foodstuffsEntity;
    }

    public FoodstuffsEntity putFoodName(String oldFoodName, String newFoodName) {
        List<FoodstuffsEntity> entities = foodstuffsDao.loadEntity();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getFoodName(), oldFoodName)) {
                break;
            }
        }
        entities.get(i).setFoodName(newFoodName);
        foodstuffsDao.saveEntity(entities);
        return entities.get(i);
    }

    public void deleteFoodByName(String foodName) {
        List<FoodstuffsEntity> entities = foodstuffsDao.loadEntity();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getFoodName(), foodName)) {
                break;
            }
        }
        foodstuffsDao.deleteEntity(entities.get(i));
    }

}