package com.example.FlipCommerce.Repository;

import com.example.FlipCommerce.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Optional<Seller> findByEmail(String sellerEmail);
}
