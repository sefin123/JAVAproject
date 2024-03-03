package com.api.service;

import com.api.dao.CategoriesDAO;
import com.api.entity.CategoriesEntity;
import com.api.entity.FoodstuffsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoriesService {

    private final CategoriesDAO categoriesDAO;

    public CategoriesService(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = categoriesDAO;
    }

    public List<FoodstuffsEntity> getCategoriesEntity(String category) {
        List<CategoriesEntity> categories = categoriesDAO.loadCategoriesEntity();
        int i = 0;
        for(; i < categories.size(); i++) {
            if (Objects.equals(categories.get(i).getCategory(), category)) {
                break;
            }
        }
        return categories.get(i).getList();
    }

    public void postCategoriesEntity(String category) {
        CategoriesEntity categoriesEntity = new CategoriesEntity(category);
        categoriesDAO.postCategoriesEntity(categoriesEntity);
    }

    public void putCategoriesEntity(String oldCategory, String newCategory) {
        List<CategoriesEntity> categories = categoriesDAO.loadCategoriesEntity();
        int i = 0;
        for(; i < categories.size(); i++) {
            if (Objects.equals(categories.get(i).getCategory(), oldCategory)) {
                break;
            }
        }
        categories.get(i).setCategory(newCategory);
        categoriesDAO.saveCategoriesEntity(categories);
    }

    public void deleteCategoriesEntity(String category) {
        List<CategoriesEntity> categories = categoriesDAO.loadCategoriesEntity();
        int i = 0;
        for(; i < categories.size(); i++) {
            if (Objects.equals(categories.get(i).getCategory(), category)) {
                break;
            }
        }
        categoriesDAO.deleteCategoriesEntity(categories.get(i));
    }

    public CategoriesDAO getCategoriesDAO() {
        return categoriesDAO;
    }
}
