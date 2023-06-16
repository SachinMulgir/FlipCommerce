package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.Dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Enum.Status;
import com.example.FlipCommerce.Model.Product;
import com.example.FlipCommerce.Model.Seller;

public class ProductTransformer {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto, Seller seller) {
        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .category(productRequestDto.getCategory())
                .availableQuantity(productRequestDto.getQuantity())
                .status(Status.AVAILABLE)
                .seller(seller)
                .build();
    }

    public static ProductResponseDto productToProductResponseDto(Product savedProduct) {
        return ProductResponseDto.builder()
                .name(savedProduct.getName())
                .category(savedProduct.getCategory())
                .price(savedProduct.getPrice())
                .sellerName(savedProduct.getSeller().getName())
                .status(savedProduct.getStatus())
                .build();
    }
}
