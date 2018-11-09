package com.links.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="CategoryEntity")
@Table(name="category_entity", schema = "myapp")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "categoryEntity", fetch = FetchType.EAGER)
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LinkEntity> linkEntityList = new ArrayList<>();




//    @ManyToOne
//    private UserInfo userInfo;


    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", linkEntityList=" + linkEntityList +
                '}';
    }
}
