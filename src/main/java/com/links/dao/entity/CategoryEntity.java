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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<LinkEntity> linkEntityList;

    @ManyToOne
    private UserInfo userInfo;

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    NotEmpty=This field is required.

    Size.userForm.username=Please use between 6 and 32 characters.
            Duplicate.userForm.username=Someone already has that username.
            Size.userForm.password=Try one with at least 8 characters.
            Diff.userForm.passwordConfirm=These passwords don't match.
}
