package com.example.FlipCommerce.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name="mobile", nullable = false, unique = true)
    String mobile;

    @Column(name="email", nullable = false, unique = true)
    String email;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    List<Product> productList = new ArrayList<>();


}
