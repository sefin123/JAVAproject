package com.api.service;

import com.api.dao.CategoriesDAO;
import com.api.dao.FoodstuffsDAO;
import com.api.dto.FoodstuffsDTO;
import com.api.entity.CategoriesEntity;
import com.api.entity.FoodstuffsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FoodstuffsService {

    private final FoodstuffsDAO foodstuffsDao;

    private final CategoriesDAO categoriesDAO;

    public FoodstuffsService(FoodstuffsDAO foodstuffsDao, CategoriesDAO categoriesDAO) {
        this.foodstuffsDao = foodstuffsDao;
        this.categoriesDAO = categoriesDAO;
    }

    public FoodstuffsDTO getFood(String foodName) {
        List<FoodstuffsEntity> entities = foodstuffsDao.loadEntity();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getFoodName(), foodName)) {
                break;
            }
        }

        List<CategoriesEntity> list = categoriesDAO.loadCategoriesEntity();
        int j = 0;
        for (; j < list.size(); j++) {
            if (Objects.equals(list.get(j), entities.get(i).getCategory())) {
                break;
            }
        }
        entities.get(i).setCategory(list.get(j));
        return new FoodstuffsDTO(entities.get(i));
    }

    public FoodstuffsEntity postFood(String foodName, int calorie, String category) {
        List<CategoriesEntity> list = categoriesDAO.loadCategoriesEntity();
        int j = 0;
        for (; j < list.size(); j++) {
            if (Objects.equals(list.get(j).getCategory(), category)) {
                break;
            }
        }
        FoodstuffsEntity foodstuffsEntity = new FoodstuffsEntity(foodName, calorie, list.get(j));
        foodstuffsDao.postEntity(foodstuffsEntity);
        return foodstuffsEntity;
    }

    public void putFoodName(String oldFoodName, String newFoodName) {
        List<FoodstuffsEntity> entities = foodstuffsDao.loadEntity();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getFoodName(), oldFoodName)) {
                break;
            }
        }
        entities.get(i).setFoodName(newFoodName);
        foodstuffsDao.saveEntity(entities);
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