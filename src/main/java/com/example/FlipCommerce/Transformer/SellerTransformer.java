package com.example.FlipCommerce.Transformer;

import com.example.FlipCommerce.Dto.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.SellerResponseDto;
import com.example.FlipCommerce.Model.Seller;

public class SellerTransformer {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobile(sellerRequestDto.getMobile())
                .build();
    }

    public static SellerResponseDto SellerToSellerResponseDto(Seller savedSeller) {
        return SellerResponseDto.builder()
                .name(savedSeller.getName())
                .mobile(savedSeller.getMobile())
                .build();
    }
}
