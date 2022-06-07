package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "stock")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @OneToMany(mappedBy = "ID")
    @Valid
    private Set<Stock> stockList = new HashSet<>();



    private String slug;

    private String name;
    private String reference;
    private double price;
    private double vat;
    private boolean stockable;


}
