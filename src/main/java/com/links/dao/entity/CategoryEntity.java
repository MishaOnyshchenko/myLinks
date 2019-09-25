package com.links.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "CategoryEntity")
@Table(name = "category_entity")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<LinkEntity> linkEntityList;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UserInfo userInfo;

}
