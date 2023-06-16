package com.example.FlipCommerce.Service.Impl;

import com.example.FlipCommerce.Dto.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.Dto.ResponseDto.SellerResponseDto;
import com.example.FlipCommerce.Model.Seller;
import com.example.FlipCommerce.Repository.SellerRepository;
import com.example.FlipCommerce.Service.SellerService;
import com.example.FlipCommerce.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        //1. ReqDto -> Entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        //2. Save entity:
        Seller savedSeller = this.sellerRepository.save(seller);

        //3. savedSeller -> ResponseDto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }
}
