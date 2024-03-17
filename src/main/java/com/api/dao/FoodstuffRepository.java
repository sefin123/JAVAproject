package com.api.dao;

import com.api.entity.Foodstuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodstuffRepository extends JpaRepository<Foodstuff, Long> {

    @Query(value = "select * from foodstuff WHERE name = :name", nativeQuery = true)
    Foodstuff getFoodByName(@Param("name") String name);

}
