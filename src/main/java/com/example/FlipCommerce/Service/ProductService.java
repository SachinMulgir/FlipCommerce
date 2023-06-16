package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.Dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto addProduct(ProductRequestDto productRequestDto);
}
