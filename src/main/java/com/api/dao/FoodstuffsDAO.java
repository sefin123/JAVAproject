package com.api.dao;

import com.api.entity.FoodstuffsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodstuffsDAO {
    private final FoodstuffsRepository foodstuffsRepository;


    public FoodstuffsDAO(FoodstuffsRepository foodstuffsRepository) {
        this.foodstuffsRepository = foodstuffsRepository;
    }

    public List<FoodstuffsEntity> loadEntity() {
        return foodstuffsRepository.findAll();
    }

    public void postEntity(FoodstuffsEntity foodstuffsEntity) { foodstuffsRepository.save(foodstuffsEntity); }

    public void saveEntity(List<FoodstuffsEntity> entities) {foodstuffsRepository.saveAll(entities);}

    public void deleteEntity(FoodstuffsEntity foodstuffsEntity) {foodstuffsRepository.delete(foodstuffsEntity);}
}
