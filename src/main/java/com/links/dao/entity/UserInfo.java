package com.links.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Объект юзер инфо который связан с объектом роли как многие ко многим и при генерации таблиц
 * создадут 3-ю таблицу которая и будет связывать эти 2 сущности по ID
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"roles", "menuTittleSet"})
//@EqualsAndHashCode(exclude = "roles")
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    private String passwordConfirm;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userInfo")
//    @JoinColumn(name = "user_info_id")
    private Set<CategoryEntity> menuTittleSet;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "user_info_id")
//    private Set<LinkEntity> links;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                '}';
    }
}