package com.links.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="CategoryEntity")
@Table(name="category_entity")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<LinkEntity> linkEntityList;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UserInfo userInfo;

//    @Override
//    public String toString() {
//        return "CategoryEntity{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
