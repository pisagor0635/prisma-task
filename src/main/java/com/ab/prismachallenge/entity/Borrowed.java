package com.ab.prismachallenge.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "borrowed")
@Data
public class Borrowed {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrower")
    private String borrower;

    @Column(name = "book")
    private String book;

    @Column(name = "borrowed_from")
    private String borrowedFrom;

    @Column(name = "borrowed_to")
    private String borrowedTo;


}
