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

    public int getCalorie(String text) {
        List<FoodstuffsEntity> entities = foodstuffsDao.loadEntity();
        int i = 0;
        for (; i < entities.size(); i++) {
            if (Objects.equals(entities.get(i).getFoodName(), text)) {
                break;
            }
        }
        return entities.get(i).getValuecalorie();
    }
}