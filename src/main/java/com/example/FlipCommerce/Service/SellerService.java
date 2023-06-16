package com.example.FlipCommerce.Service;

import com.example.FlipCommerce.Dto.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.SellerResponseDto;

public interface SellerService {
    SellerResponseDto addSeller(SellerRequestDto sellerRequestDto);
}
