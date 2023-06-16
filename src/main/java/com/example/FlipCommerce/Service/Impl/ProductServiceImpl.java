package com.example.FlipCommerce.Service.Impl;

import com.example.FlipCommerce.Dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Model.Seller;
import com.example.FlipCommerce.Repository.ProductRepository;
import com.example.FlipCommerce.Repository.SellerRepository;
import com.example.FlipCommerce.Service.ProductService;
import com.example.FlipCommerce.Transformer.ProductTransformer;
import com.example.FlipCommerce.exception.EntityNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws EntityNotPresentException {

        // CHECK SELLER EXIST OR NOT:
        String sellerEmail = productRequestDto.getSellerEmail();
        Optional<Seller> optionalSeller = this.sellerRepository.findByEmail(sellerEmail);
        if( optionalSeller.isEmpty() ){
            throw new EntityNotPresentException("Seller not found!!");
        }

        Seller seller = optionalSeller.get();

        //1. RequestDto -> Entity:
        Product product = ProductTransformer.productRequestDtoToProduct(productRequestDto, seller);

        //2. Save entity:
        Product savedProduct = this.productRepository.save(product);
        seller.getProductList().add(savedProduct);
        this.sellerRepository.save(seller);

        //3. Entity -> ResponseDto
        return ProductTransformer.productToProductResponseDto(savedProduct);
    }
}
