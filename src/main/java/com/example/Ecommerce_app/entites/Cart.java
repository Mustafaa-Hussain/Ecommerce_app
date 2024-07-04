package com.example.Ecommerce_app.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
}
