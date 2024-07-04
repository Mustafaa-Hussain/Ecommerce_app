package com.example.Ecommerce_app.entites.order;


import com.example.Ecommerce_app.entites.Item;
import com.example.Ecommerce_app.entites.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Double totalAmount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
    private String shippingAddress;
}
