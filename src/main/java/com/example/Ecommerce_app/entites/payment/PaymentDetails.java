package com.example.Ecommerce_app.entites.payment;

import com.example.Ecommerce_app.entites.order.Order;
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
@Table(name = "payment_details")
public class PaymentDetails {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Order order;

    private Date paymentDate;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

}
