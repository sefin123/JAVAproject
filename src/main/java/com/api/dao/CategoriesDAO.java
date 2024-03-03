package com.api.dao;

import com.api.entity.CategoriesEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesDAO {
    private final CategoriesRepository categoriesRepository;

    public CategoriesDAO(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<CategoriesEntity> loadCategoriesEntity() { return categoriesRepository.findAll(); }

    public void postCategoriesEntity(CategoriesEntity categoriesEntity) { categoriesRepository.save(categoriesEntity); }

    public void saveCategoriesEntity(List<CategoriesEntity> categories) { categoriesRepository.saveAll(categories); }

    public void deleteCategoriesEntity(CategoriesEntity categoriesEntity) { categoriesRepository.delete(categoriesEntity);}
}
