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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orderEntity")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column( nullable = false, unique = true)
    int orderId;            //UUID

    @Column(name = "quantity")
    int quantity;

    int totalAmount;

    @CreationTimestamp
    Date orderDate;

    @Enumerated(EnumType.STRING)
    Status status;

    String cardUsed;                              //not mapped-> we will get ******1234 value;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();
}
