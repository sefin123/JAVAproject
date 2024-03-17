package com.api.dao;

import com.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CategoryRepository extends JpaRepository<Category, Long> {

        @Query(value = "select * from category WHERE name = :name", nativeQuery = true)
        Category getCategoryByName(@Param("name") String name);

    }
