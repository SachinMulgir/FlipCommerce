package com.example.FlipCommerce.Model;

import com.example.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "cardNo", nullable = false, unique = true)
    String cardNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "Card_type")
    CardType cardType;

    @Column(name = "Expiry_date")
    Date validTill;

    @Column(name = "cvv", nullable = false)
    int cvv;

    @ManyToOne
    @JoinColumn
    Customer customer;

}
