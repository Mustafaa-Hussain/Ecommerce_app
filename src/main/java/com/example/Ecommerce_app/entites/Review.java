package com.example.Ecommerce_app.entites;

import com.example.Ecommerce_app.entites.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer rating;
    private String comment;
    private Date reviewDate;
}
