package com.api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<FoodstuffsEntity> list;

    public CategoriesEntity(String category) {
        this.category = category;
    }

    public CategoriesEntity() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<FoodstuffsEntity> getList() {
        return list;
    }

    public void setList(List<FoodstuffsEntity> list) {
        this.list = list;
    }
}
