package com.api.dao;
import com.api.entity.FoodstuffsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodstuffsRepository extends JpaRepository<FoodstuffsEntity, Long> {

}
