package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "card")
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
