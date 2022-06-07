package com.example.demo.Entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "stock")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "ID")
    private Customer customer;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate updateAt;


    public void setDateCreated(LocalDate dateCreated) {
        this.updateAt = dateCreated;
    }
}
