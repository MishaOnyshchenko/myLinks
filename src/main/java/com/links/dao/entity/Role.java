package com.links.dao.entity;



import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "userInfo")
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ToString.Exclude
    @ManyToMany(mappedBy = "roles")
    private Set<UserInfo> userInfo;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Role(String name) {
        this.name = name;
    }
}
