package com.example.Ecommerce_app.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private Double price;

    @ManyToMany
    private Category category;

    private Integer stock;
//    image url
    private String imageUrl;
}
