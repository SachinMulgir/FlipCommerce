package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.Dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.Enum.Category;

import java.util.List;

public interface ProductService {
    ProductResponseDto addProduct(ProductRequestDto productRequestDto);

    List<ProductResponseDto> getProductByCategoryAndPrice(Category category, int price);

}
