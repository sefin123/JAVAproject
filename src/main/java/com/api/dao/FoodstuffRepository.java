package com.api.dao;

import com.api.entity.Foodstuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodstuffRepository extends JpaRepository<Foodstuff, Long> {

    @Query(value = "select * from foodstuff WHERE name = :name", nativeQuery = true)
    Foodstuff getFoodByName(@Param("name") String name);

    @Query(value = "select * from foodstuff", nativeQuery = true)
    List<Foodstuff> getFoods();

}
