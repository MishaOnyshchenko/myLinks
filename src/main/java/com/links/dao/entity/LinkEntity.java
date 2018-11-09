package com.links.dao.entity;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "LinkEntity")
@Table(name="link_entity", schema = "myapp")
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String url;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity categoryEntity;




}
