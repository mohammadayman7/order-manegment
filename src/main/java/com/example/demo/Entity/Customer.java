package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;


import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "stock")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "ID")
    @Valid
    private Set<Order> orderList = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate bornAt;
}