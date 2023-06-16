package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(nullable = false, unique = true)
    String cardNo;

    @Enumerated(EnumType.STRING)
    CardType cardType;


    Date validTill;


    int cvv;

    @ManyToOne
    @JoinColumn
    Customer customer;

}
