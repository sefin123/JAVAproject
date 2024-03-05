package com.api.dao;
import com.api.entity.Foodstuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodstuffRepository extends JpaRepository<Foodstuff, Long> {

}
