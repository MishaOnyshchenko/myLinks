package com.links.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Объект юзер инфо который связан с объектом роли как многие ко многим и при генерации таблиц
 * создадут 3-ю таблицу которая и будет связывать эти 2 сущности по ID
 */

@Data
@EqualsAndHashCode(exclude = {"roles", "listMenu"})
//@EqualsAndHashCode(exclude = "roles")
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String passwordConfirm;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userInfo")
//    private Set<CategoryEntity> menuTittleSet;

    @OneToMany
    private List<CategoryEntity> listMenu;



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
