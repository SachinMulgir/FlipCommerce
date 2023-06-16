package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enum.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "Order_id", nullable = false, unique = true)
    int orderId;            //UUID

    @Column(name = "Quantity")
    int quantity;

    @Column(name = "Total_Amount")
    int totalAmount;

    @CreationTimestamp
    @Column(name = "Date_of_order")
    Date orderDate;

    @Column(name = "Order_Status")
    @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "Card_used")
    Card cardUsed;                              //not mapped-> we will get ******1234 value;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();
}
