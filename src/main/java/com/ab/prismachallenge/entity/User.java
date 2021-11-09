package com.ab.prismachallenge.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "member_since")
    private String memberSince;

    @Column(name = "member_till")
    private String memberTill;

    @Column(name = "gender")
    private String gender;
}
