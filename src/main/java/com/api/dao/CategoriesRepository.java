package com.api.dao;

import com.api.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CategoriesRepository  extends JpaRepository<CategoriesEntity, Long> {

    }
