package com.example.springboot3batchtry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    private Long id;
    private String name;

    // getter / setter
}
