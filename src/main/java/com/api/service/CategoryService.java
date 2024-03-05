package com.api.service;

import com.api.dao.CategoryRepository;
import com.api.dto.CategoryDTO;
import com.api.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO getCategoriesEntity(String category) {
        List<Category> categories = categoryRepository.findAll();
        int i = 0;
        for(; i < categories.size(); i++) {
            if (Objects.equals(categories.get(i).getName(), category)) {
                break;
            }
        }
        return new CategoryDTO(categories.get(i));
    }

    public void postCategoriesEntity(String category) {
        Category categoriesEntity = new Category(category);
        categoryRepository.save(categoriesEntity);
    }

    public void putCategoriesEntity(String oldCategory, String newCategory) {
        List<Category> categories = categoryRepository.findAll();
        int i = 0;
        for(; i < categories.size(); i++) {
            if (Objects.equals(categories.get(i).getName(), oldCategory)) {
                break;
            }
        }
        categories.get(i).setName(newCategory);
        categoryRepository.saveAll(categories);
    }

    public void deleteCategoriesEntity(String category) {
        List<Category> categories = categoryRepository.findAll();
        int i = 0;
        for(; i < categories.size(); i++) {
            if (Objects.equals(categories.get(i).getName(), category)) {
                break;
            }
        }
        categoryRepository.delete(categories.get(i));
    }
}
