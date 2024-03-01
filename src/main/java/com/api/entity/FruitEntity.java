package com.api.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class FruitEntity {

    @Id
    @Column(name = "id")
    private Long id;

}
