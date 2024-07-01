package com.example.Ecommerce_app.entites.order;


import ch.qos.logback.core.status.Status;
import com.example.Ecommerce_app.entites.Item;
import com.example.Ecommerce_app.entites.Product;
import com.example.Ecommerce_app.entites.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ManyToMany
    private User user;
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Double totalAmount;
    private List<Item> items;
    private String shippingAddress;
}
