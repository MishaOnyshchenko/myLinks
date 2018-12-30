package com.links.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Data
@Entity(name = "LinkEntity")
@Table(name="link_entity")
public class LinkEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String url;

    @Column
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
//    @JsonIgnore
//    private CategoryEntity categoryEntity;

    @ManyToOne
    private CategoryEntity categoryEntity;

    @Override
    public String toString() {
        return "LinkEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


