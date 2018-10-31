package com.links.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table

public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String description;
}
