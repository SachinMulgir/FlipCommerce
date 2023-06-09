package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "mobile",  nullable = false, unique = true)
    String mobile;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "address")
    String address;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Card> cardList = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<OrderEntity> orderEntityList = new ArrayList<>();

}
