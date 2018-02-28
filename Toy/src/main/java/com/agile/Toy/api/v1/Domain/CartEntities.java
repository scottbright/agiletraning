package com.agile.Toy.api.v1.Domain;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class CartEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cartId;

    private Long toyId;

    private Integer orderQuantity;
}
