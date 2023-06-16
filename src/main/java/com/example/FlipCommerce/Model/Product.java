package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Enum.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    int price;

    @Column(name = "available_quantity")
    int availableQuantity;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    Category category;

    @Column(name = "status")
    Status status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Seller seller;


}
