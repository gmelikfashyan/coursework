package com.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product
{
    @Id
    private int id;
    private String name;
    private String brand;
    private String productPrice;
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItem;
}
