package com.api.service;

import com.api.component.Cache;
import com.api.dao.CategoryRepository;
import com.api.dto.CategoryDTO;
import com.api.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService {

    private static final String LOG_STRING = " found in cache";

    private final CategoryRepository categoryRepository;

    private final Cache cache;

    public CategoryService(CategoryRepository categoryRepository, Cache cache) {
        this.categoryRepository = categoryRepository;
        this.cache = cache;
    }

    public CategoryDTO getCategoriesEntity(String name) {

        CategoryDTO category = (CategoryDTO) cache.get(name);
        if(category != null){
            log.info(category.getCategory() + LOG_STRING);
            return category;
        }

        Category entity = categoryRepository.getCategoryByName(name);

        cache.put(name, new CategoryDTO(entity));

        return new CategoryDTO(entity);
    }

    public void postCategoriesEntity(String name) {
        Category entity = new Category(name);

        categoryRepository.save(entity);
    }

    public void putCategoriesEntity(String oldName, String newName) {
        Category entity = categoryRepository.getCategoryByName(oldName);

        entity.setName(newName);

        cache.remove(oldName);

        categoryRepository.save(entity);
    }

    public void deleteCategoriesEntity(String name) {
        Category entity = categoryRepository.getCategoryByName(name);

        cache.remove(name);

        categoryRepository.delete(entity);
    }
}
